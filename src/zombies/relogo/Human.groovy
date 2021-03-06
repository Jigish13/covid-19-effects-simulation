package zombies.relogo

import static repast.simphony.relogo.Utility.*
import static repast.simphony.relogo.UtilityG.*

import repast.simphony.relogo.Plural
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Utility
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.schedule.Go
import repast.simphony.relogo.schedule.Setup
import zombies.ReLogoTurtle



class Human extends ReLogoTurtle {

	def infected = false
	def infectionTime = 0
	def inHospital = false
	
	def step()
	{
		def winner = minOneOf(neighbors())
				{
					count(zombiesOn(it))
				}
		face(winner)
		forward(1.5)
		if(infected)
		{
			infectionTime++
			if(infectionTime >= gestationPeriod)
			{
				hatchZombies(1)
				{
					size = 2
					numZombies++
				}
				if(numZombies > hospitalCapacity)
				{
					die()
				}
			}
		}
	}
}
