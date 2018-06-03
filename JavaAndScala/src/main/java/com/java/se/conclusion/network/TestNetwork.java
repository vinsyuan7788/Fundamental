package com.java.se.conclusion.network;

/**
 * 	This is a class to test network programming
 * 
 * 	Network programming: resolve the communication between computers (lap-tops, cell-phones, etc.); C-S model oriented
 *  -- 3 elements: IP, port, protocol
 *  -- Computer network: the system where computers distributed in different areas can communicate & share resources mutually by external devices
 *  Web programming: resolve the communication based on html (browser, etc.); B-S model oriented
 *  -- 3 layers: web (sevlet, filter, listener) or action or controller, service or business, DAO (Data Access Object)
 *  
 *  For JavaWeb field: proficient in web programming & network theory, familiar with network programming (*****)
 *  For network field: proficient in network programming & network theory, familiar with web programming
 *
 * 	TCP (Transmission Control Protocol) features：
 * 	-- I/O-stream based
 * 	-- No size limitation during transmission
 * 	-- Connection-oriented communication: MUST make sure the other side can process the request
 *     -- E.g., making phone call, transmitting files, download, etc.
 *     -- 3-way handshake: ensure data integrity and reliability 
 *     -- Relatively slower compared with UDP
 * 	-- Distinguish client and server 
 *     -- Either client or server can be both sender and receiver
 *  
 *  UDP (User Data-gram Protocol) features：
 * 	-- Packet based
 * 	-- Max size is 64K for each packet during transmission
 * 	-- Connectionless communication: NO NEED to make sure the other side can process the request
 *     -- E.g., writing letters, online games, etc.
 * 	   -- Not guarantee data integrity and reliability
 *     -- Relatively faster compared with TCP
 * 	-- Does not distinguish client and server
 *     -- Only distinguish sender and receiver
 *     
 *  About network:
 *  -- Load balancing
 *  -- Network (or broadcast) radiation: 
 *  -- 7-layer OSI (Open System Interconnection) model: 
 *     -- Application: the layer the user is actually interacting with
 *        -- E.g., Chrome, Firefox, Safari, etc.
 *     -- Representation: the layer that the OS is on 
 *        -- E.g., Linux, Windows, Mac, etc.
 *     -- Session: the layer that actually creates a session between computers
 *        -- This is where Java Web programming actually works on
 *     -- Transport: the layer that decides how the information should be transmitted
 *     -- Network: the layer that routers operate on
 *        -- This is where Java network programming actually works on
 *        -- This is where most of the network concept that should be understood is
 *           -- E.g., TCP/IP (IP address, sub-net (or net) mask, default gateway, DHCP, DNS, NAT), etc.
 *     -- Data link: the layer that switches (or bridges, etc.) operate on
 *        -- This is where little of the network concept that should be understood is
 *           -- E.g., segment
 *     -- Physical: the layer where all the physical stuff (coaxial cable, fiber, hub, etc.) connect computers together
 *  
 *  About TCP/IP:
 *  -- Work-flow: A computer [--- (DHCP or static) ---> IP address] requests a target --- (DNS) ---> target IP address --- (search current network, if not found then through default gateway) ---> reach the target
 *     -- IP address: unique identifier of the computer in current (NOT global) network
 *        -- DHCP (Dynamic Host Configuration Protocol): used to auto-assign IP address to a computer
 *           -- Conversely, "static" means manually assign an IP address to a computer
 *        -- DNS (Domain Name System): to parse the domain name to domain IP address
 *           -- Can be either local (higher priority and can be configured on the local computer) or global (lower priority and on an external server)
 *        -- IP address = segment + local address
 *     -- Segment: the address of current network
 *        -- Segment = IP address AND sub-net (or net) mask
 *     -- Default gateway: the IP address of the router in current network 
 *        -- Default gateway MUST have the same segment as IP address (because gateway is serving for current network)
 *        -- NAT (Network Address Translation): to map public address of current network and private address of any computer in current network
 *  
 * @author VinceYuan
 *
 */
public class TestNetwork {

}
