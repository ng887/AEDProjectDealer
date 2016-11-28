package dao;

import java.io.*;

/**
 * @author Neha
 **/

public abstract class ReadFile {

	public void ReadFileHelper(File fileName) {

		try {
			FileReader fr;
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String line;

			while ((line = br.readLine()) != null) {
				ReadFileLine(line);
				// br.close();
				// fr.close();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("file not exists!");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

	public abstract void ReadFileLine(String line);
}
