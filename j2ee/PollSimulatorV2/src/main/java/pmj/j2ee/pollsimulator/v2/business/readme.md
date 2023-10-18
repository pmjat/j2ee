
# Poll Simulator Ver 2

Change summary

1. Add PollService
2. Make Poll to PollBO; hopefully more cohesive now!
3. PollBO and Candidate are not exposed to presentation tier
4. CandidateTO is added for Data transfer to the presentation tier
5. PollBO and Candidates can be made persistent

Following of Poll move to Service
1. "voted" collection
2. Method getWinner
3. getRejected function to Service
