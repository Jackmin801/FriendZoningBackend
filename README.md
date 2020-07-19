# FriendZoningBackend
A backend I did using the Spring Framework for my Data Structures course assignment at Universiti Malaya. The assignment was to create a classic dating app with the twist that the app aims to get the user friendzoned instead of getting a potential partner.

<h3>Features</h3>
<p> Dynamically updating chat using Web Sockets</p>
<p> Basic username and password authentication</p>
<p> Basic registration</p>
<p> Redis Database</p>
<p> Service to find nearby users</p>
<p> Service to calculate match between 2 users based on registered interests</p>
<p> Service to convert chat messages using an antonym dictionary and uwu-ify</p>
<p> TEA encryption on chat messages</p>

<h3>Grievances:</h3>
<p> I did not know about the existence of the Principal object in Spring when I was doing the authentication module. This leads to a slightly clunky method of authenticating sessions where the frontend is required to send a request specifying who they are and their key in the body instead of the header.</p>
<p> I did not how the Spring framework dispatcher servlet actually worked until the last part of the project when working on the chat. Therefore, the APIs built do not return the appropriate statuses (It either returns 200 if it worked, or 500 if it didn't)</p>
<p> I had originally intended to have a separate service doing semantic analysis to flip the semantics of the chat messages instead of the specified antonym dictionary. Turns out, semantic analysis isn't simple and my model was not stable enough for me to be confident to use it in a demo. So I stuck with the dictionary and added an uwu-ify filter instead.</p>
<p> The encryption algorithm used (TEA) is known to be brute-forceable. The entire backend also uses one key that is plain-text in the source code to encrypt the messages instead of having separate keystores for each user. This was just me being lazy as it was just an assignment, sorry.</p>
