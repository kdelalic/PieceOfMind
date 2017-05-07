# **  PieceOfMind**

## Summary
Piece of Mind is a Java EE application built on Apache Tomcat that provides
analytics on the attitudes of Twitter users as individuals and as a collective.
Users of Piece of Mind will have access to hundreds of thousands of nodes
of precompiled twitter data, in addition to having access to new data that is
streamed live from the Twitter API. This data will be analyzed and presented
to the user, highlighting the sentiment trends of both individual Twitter
users and larger collections of Twitter users. The ideal users of Piece of
Mind are individuals looking to understand the sentiment trends of other
individuals, or businesses and other public entities looking to gain insight on
public opinion around a given topic.

![Class Diagram]({{site.baseurl}}/https://i.imgur.com/McLFwvY.png)

## Internal Review
Piece of Mind turned out to be a very interesting project with a unique set
of challenges and rewards.

Initially, Piece of Mind began as an application that would strictly examine
precompiled datasets of Twitter data. This seemed to be satisfactory at
the time, and development began with that end in mind. Algorithms such
as Quicksort and Binary Search were implemented, in additional to several
ADTs, and Apache Tomcat itself. However, it was eventually realized that
there were two major issues with using only a premade dataset.

First, analyzing old Twitter data is a lot less relevant than analyzing up to
date data.

Second, there was no conceivable use for a graphing algorithm when working
with only old, static Twitter data.

With these two issues in mind, it was decided that Piece of Mind should
implement a live access to the Twitter streaming API to provide extremely
current data and to provide more obvious relationships between tweets that
could be graphed, such as in-depth location and retweet data.
This was a very exciting and interesting idea, but it certainly presented its
own set of challenges. After much experimenting, it became apparent that
some of the initial assumptions made involving the Twitter streaming API
were incorrect.

The idea for the use of graphing algorithms was simple: when an influential
person tweeted about a given subject, their tweet would be followed by a
large number of retweets. Our objective was to detect that increase in the
rate of retweets about a given subject, determine the individual who made
the initial tweet, and, using them as the central node in an edge-weighted
digraph, represent the propogation of retweets as branches out of the central
node. See figure 1 for an illustration.

![Figure 1]({{site.baseurl}}//2017-05-07%2015_22_23-PieceOfMind.pdf.png)
Figure 1

By analyzing the sentiments of the retweets as they propogated away from
the source, businesses and advertisers would be able to evaluate the effects of
advertisements and marketing campaigns. Obviously, if the sum of all of the
weights (sentiments) of the retweets was very positive, then the advertising
could be considered a success, as people were talking about the product in a
positive manner.

The issue we ran into, however, was that the Twitter streaming API does
not return all tweets. This was a major, unforseen problem. Thus, the code
for this graphing application is included in the project but is not functional
due to issues with the Twitter API. See: EdgeWeightedDigraph.java.
