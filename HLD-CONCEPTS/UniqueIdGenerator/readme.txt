References : 

     UniqueIdGenerator : https://completedesigninterviewcourse.com/system-design-generating-unique-identifiers-distributed-systems-twitter-snowflake-id/


UNIQUE ID GENERATOR  : 

      Twitter's Snowflake is a distributed unique ID generator designed to generate IDs for large-scale distributed systems. 
      It was created to address the need for a unique identifier generation system that can scale horizontally without centralized 
      coordination.

   Snowflake IDs are 64-bit unsigned integers composed of three parts:

        1. Timestamp (41 bits): The timestamp represents the number of milliseconds since a custom epoch. 
           This allows the IDs to be roughly ordered by time.

        2. Worker ID (10 bits): The worker ID identifies the machine generating the ID.
           This allows multiple machines to generate IDs without conflicts.

        3. Sequence Number (12 bits): The sequence number is an incrementing value generated in the same millisecond 
           from the same machine. It prevents collisions in case multiple IDs are generated within the same millisecond.

    
    what is worker Id ? 

        Imagine you have a big online store with many servers. Each server needs to generate unique order numbers for the orders it processes.
        To ensure that two servers don't accidentally create the same order number, each server is given a unique "worker ID."

        Let's say you have 4 servers, and you decide to assign them worker IDs like this:

        Server 1: Worker ID 0001
        Server 2: Worker ID 0010
        Server 3: Worker ID 0011
        Server 4: Worker ID 0100
        Each worker ID is a unique pattern of 4 bits (in this example, but in real Snowflake it's 10 bits). 
        These IDs are like names for the servers. When a server needs to create an order number, it uses its worker ID as part of the number.
        For example, if Server 1 (worker ID 0001) needs to create an order number, it might combine its worker ID with the current time and a
        sequence number to create a unique order number like 0001-123456789-001.

        By using worker IDs, each server can create its own unique order numbers without worrying about conflicting with the numbers created 
        by other servers. This helps keep things organized and prevents mistakes or confusion.


    What is Sequence Number ? 

        Imagine you have a machine that needs to create unique IDs for things. It's really fast, so it can create many IDs in just one second
        (a millisecond is a thousandth of a second). To make sure each ID is different, the machine uses a "sequence number."

        The sequence number is like a counter that starts at 0 and goes up by 1 each time the machine creates an ID. So, the first ID might be 0001,
        the second ID might be 0002, and so on. The sequence number is reset to 0 every millisecond, so it's always starting fresh.

        By using the sequence number, even if the machine creates many IDs in the same millisecond, each ID will still be unique because the 
        sequence number is different for each one. This helps prevent two IDs from accidentally being the same, even if they're created very quickly.
                        

    BreakDown of snowflake Id structure : 
       
           
            0                                                      41     51         64
            +------------------------------------------------------+-------+-----------+
            |                  timestamp (milliseconds)             | worker| sequence  |
            +------------------------------------------------------+-------+-----------+

                    
           The timestamp occupies the most significant 41 bits, which allows for a timestamp range of approximately 69 years.

           The worker ID is used to identify the machine generating the ID. This allows for up to 1024 (2^10) unique machines.

           The sequence number is used to differentiate IDs generated within the same millisecond by the same machine. It can range 
           from 0 to 4095 (2^12 - 1) and resets to 0 every millisecond.

           By combining these three parts, Snowflake generates unique IDs that are sortable by time and can be generated across 
           multiple machines without the need for centralized coordination.



