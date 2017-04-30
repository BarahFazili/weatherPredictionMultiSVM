iimport java.io.FileReader;

import java.util.HashSet;

import java.util.Set;

import weka.core.Instances;

public class Initializer{

    public double[][] local_sgd;

    public static Set<Double> ClassSet = new HashSet<Double>();

    // public String[] classArray= new String[3];

    private static final String PAR_PATH = "resourcepath";
    /** used to generate unique IDs */

    private static long counter = -1;
    // the weight matrix
    public double[][] wtVec;
    public int num_class; // total no. of classes
    public int num_Att;
    public static int c;
    public int count = 0;
    private long ID; // The ID

    public int max_class = 10;
    protected double lambda = 0.01;

    /** Learning rate */
    protected double alpha = 0.02;

    private String resourcepath;
    public Instances traindataset; // The training dataset
    private long nextID()

    {
        return counter++;

    }
      	 public void setID(long nextID)

	    {
	        ID = nextID;
	    }

	public long getID() {
		return ID;

	}
	    
	   public Initialzer()

	    {
	        resourcepath = (String) Configuration.getString(prefix + "." + PAR_PATH);

	        // N= Configuration.getInt(prefix + "."+PAR_SIZE);

	        System.out.println("Data is saved in: " + resourcepath + "\n"); //

	        setID(nextID());

	        // read the data into node

	        try {

	            String traindataset = resourcepath + "/" + "weather_dataset_"

	            		 + ".arff";

	            // Instances data= traindataset.getDataSet();

	            FileReader reader = new FileReader(traindataset);

	            Instances data = new Instances(reader);


	            // printing the number of attributes

	            num_Att = data.numAttributes() - 1;

	            System.out.println("Number of Attributes" + " " + num_Att + "\n");

	            // total number of instances

	            int num_Instance = data.numInstances();

	            System.out.println("Number of instances "+ " " + num_Instance + "\n");



	            // set the last attribute to be the class attribute

	            int label = data.numAttributes();

	            data.setClassIndex(label - 1);

	            // System.out.println("\n"+label);


	            int N = data.numInstances(); // data size at each node

	            for (int i = 0; i < N; i++) // Adding unique classes to Hashset	            {

	                double y = data.instance(i).value(label - 1);
	                // System.out.println("\n"+y);

	                ClassSet.add(y);



	            }


	            // Initialize the weight vector dxc dimension where d is the num ber

	            // of attributes and c is the total number of classes

	            wtVec = new double[num_Att][max_class];



	            for (int j = 0; j < num_Att; j++)

	            {

	                for (int k = 0; k < max_class; k++)

	                {

	                    wtVec[j][k] = 1;



	                }

	            }



	           

	        }


	
	        catch (Exception e)

	        {

	            e.printStackTrace();

	        }


	    }

	   

	   public static int write_class_size()

	    {



	        c = ClassSet.size();

	        // System.out.println("\n"+ClassSet.size());

	        return c;

	    }





}
Contact GitHub API Training Shop Blog About 

© 2017 GitHub, Inc. Terms Privacy Security Status Help 
