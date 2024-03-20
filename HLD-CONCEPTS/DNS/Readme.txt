
    REFERENCES : 
         
          Blog : https://www.cloudflare.com/learning/dns/what-is-dns/


    DNS(DOMAIN NAME SYSTEM) :
         
          DNS, or Domain Name System, is like the internet's phonebook. It translates human-friendly domain names (like example.com) into IP addresses (like 192.0.2.1) 
          that computers use to identify each other on the network.

          Example: Let's say you want to visit "google.com". Your computer checks its cache, but it doesn't have the IP address. It sends a request to a DNS server. 
          The DNS server looks up "google.com" and finds its IP address (let's say, 172.217.12.206). The DNS server sends this IP address back to your computer. 
          Your computer then uses this IP address to connect to Google's servers and load the webpage.


          DNS Servers: 
              
              DNS servers are like internet directories that store information about domain names and their corresponding IP addresses. When you type a domain name into your web browser, 
              your computer sends a request to a DNS server to find the IP address associated with that domain name.

        DNS Server Involved in processes of loading a page ? 
             
             Root DNS Servers: 
                  
                  These are the first step in the DNS lookup process. They are responsible for directing requests to the appropriate Top-Level Domain (TLD) 
                  name servers based on the domain name being queried.

            TLD DNS Servers: 
                
                 Top-Level Domain (TLD) name servers are responsible for storing information about the specific top-level domain (like .com, .org, .net, etc.). 
                 They provide information about which authoritative name server is responsible for a specific domain.

            Authoritative DNS Servers: 
                 
                 These are the DNS servers that hold the actual DNS records for a domain, such as A records (mapping domain names to IP addresses), MX records (for email servers), etc. 
                 When a request reaches the authoritative DNS server, it returns the requested DNS information.

            Recursive DNS Servers: 
                 
                 These are DNS servers typically operated by ISPs or other organizations. They perform the recursive process of querying multiple DNS servers to find the IP address 
                 associated with a domain name. Recursive DNS servers cache DNS information to improve performance and reduce the load on root and TLD DNS servers.

            When you type a domain name into your web browser, your computer first checks its local cache, then queries a recursive DNS server. The recursive DNS server then queries the root DNS servers, 
            TLD DNS servers, and finally, the authoritative DNS servers to resolve the domain name to an IP address.

        
        DNS RESOLUTION PROCESS :  
               
               When you type a domain name into your web browser and hit Enter, your computer first checks its local cache to see if it already knows the corresponding IP address. 
               If not, it sends a request to a DNS server. The DNS server checks its own cache and if it doesn't have the information, it forwards the request to other DNS servers until 
               it finds the IP address. Once the IP address is found, it is returned to your computer, which can then connect to the website using the IP address.

          STEPS : 
             
                Local Cache Check: 

                    When you type a website address into your browser, your computer first checks its local cache to see if it already knows the corresponding IP address. 
                    This cache is like a memory where your computer stores recent DNS lookups to speed up future requests.

                DNS Server Request: 
                    
                    If the IP address is not found in the local cache, your computer sends a request to a DNS server. This DNS server is usually provided by your 
                    Internet Service Provider (ISP) or network administrator. The request contains the website address (like google.com) that you want to visit.

                DNS Server Cache Check: 
                    
                    The DNS server checks its own cache to see if it already knows the IP address for the requested website. If it finds the IP address in its cache, 
                    it immediately returns the IP address to your computer. This is similar to how your computer's cache works but on a larger scale.

                Recursive DNS Server: 
                    
                    If the IP address is not found in the DNS server's cache, the DNS server becomes a "recursive" DNS server. It starts a process of querying other DNS servers to 
                    find the IP address. It first queries the "root" DNS servers, which are like the starting point of the DNS system.

                Root DNS Servers: 
                    
                    The root DNS servers do not have the IP address for the requested website. Instead, they direct the DNS server to the next level of DNS servers, which are responsible 
                    for the top-level domains (TLDs) like .com, .org, .net, etc.

                TLD DNS Servers: 
                    
                    The TLD DNS servers contain information about which authoritative DNS servers are responsible for specific domain names. The DNS server queries the TLD DNS servers to 
                    find the authoritative DNS server for the requested website.

                Authoritative DNS Server: 
                
                    The authoritative DNS server holds the actual IP address for the requested website. The DNS server queries the authoritative DNS server, which returns the IP address.

                IP Address Return: 
                    
                    Once the DNS server has the IP address, it returns it to your computer. Your computer then uses this IP address to connect to the website's server and load the webpage.

                Overall, the DNS resolution process involves checking local caches, querying DNS servers, and following a chain of DNS servers until the IP address for the requested website is found. 
                This process allows you to access websites on the internet using easy-to-remember domain names.


    Additional information : 
         
          Read about : 
            
            1. recursive query 
            2. iterative query 
            3. non iterative query