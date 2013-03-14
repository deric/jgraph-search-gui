package cz.cvut.fit.zum.api.ga;

import cz.cvut.fit.zum.ga.Individual;
import java.util.Arrays;

/**
 *
 * @author Tomas Barton
 */
public class AbstractPopulation {

    private Individual[] individuals = null;
    protected double avgFitness = 0;
    private double bestFitness = 0;

    /* ################################################################### */
    /*    BASICALLY, YOU DO NOT NEED TO TOUCH THIS CODE                    */
    /* ################################################################### */
    /**
     * Constructor
     *
     * @param size is count of individuals in population
     */
    public AbstractPopulation(AbstractEvolution evolution, int size) {
        individuals = new Individual[size];
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual(evolution);
            individuals[i].countFitness();
        }
        getAvgFitness();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== POPULATION ===\n");
        for (int i = 0; i < individuals.length; i++) {
            sb.append(individuals[i].toString());
            sb.append("\n");
        }
        sb.append("=== avgFIT: ").append(avgFitness).append(" ===\n");
        return sb.toString();
    }

    /**
     * Method counts fitness of each individual and averages it.
     *
     * @return average fitness value
     */
    public double getAvgFitness() {
        avgFitness = 0;
        for (int i = 0; i < individuals.length; i++) {
            individuals[i].countFitness();
            avgFitness += individuals[i].getFitness();
            bestFitness = Math.max(bestFitness, individuals[i].getFitness());
        }
        avgFitness = avgFitness / individuals.length;
        return avgFitness;
    }

    /**
     * Returns best individual from population
     *
     * @return best individual
     */
    public Individual getBestIndividual() {
        Individual best = this.individuals[0];
        for (int i = 0; i < this.individuals.length; i++) {
            if (this.individuals[i].getFitness() > best.getFitness()) {
                best = this.individuals[i];
            }
        }
        return best;
    }

    /**
     * This methods needs that Individual implements interface Comparable.
     */
    public void sortByFitness() {
        Arrays.sort(individuals);
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    
    public int individualSize(){
        return individuals.length;
    }
    
    public Individual getIndividual(int idx){
        return this.individuals[idx];
    }
    
    public void setIndividuals(int index, Individual individual){
        individuals[index] = individual;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
    
    
}