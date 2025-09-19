package vk.learning.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public class CsvCollector {

	public static Collector<String, ?, String> toCsv(int maxLineWidth) {
		return Collector.of(() -> new CsvAccumulator(maxLineWidth), CsvAccumulator::add,
				CsvAccumulator::combine, CsvAccumulator::finish);
	}

	// Accumulator class
	private static class CsvAccumulator {
		private final int maxLineWidth;
		private final List<String> lines = new ArrayList<>();
		private final StringBuilder currentLine = new StringBuilder();

		public CsvAccumulator(int maxLineWidth) {
			this.maxLineWidth = maxLineWidth;
		}

		public void add(String word) {
			if (currentLine.length() == 0) {
				currentLine.append(word);
			} else if (currentLine.length() + 1 + word.length() <= maxLineWidth) {
				currentLine.append(",").append(word);
			} else {
				lines.add(currentLine.toString());
				currentLine.setLength(0);
				currentLine.append(word);
			}
		}

		public CsvAccumulator combine(CsvAccumulator other) {
			// For simplicity, just add other's lines at the end
			if (other.currentLine.length() > 0) {
				other.lines.add(other.currentLine.toString());
			}
			for (String line : other.lines) {
				this.add(line); // May exceed line width if line already formed
			}
			return this;
		}

		public String finish() {
			if (currentLine.length() > 0) {
				lines.add(currentLine.toString());
			}
			return String.join("\n", lines);
		}
	}

	// Example usage
	public static void main(String[] args) {
		List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");

		String csv = words.stream().collect(CsvCollector.toCsv(20));
		System.out.println(csv);
		// docker -> getting the environment variable , command
		// kubernetes pod scaling, brain storming
		// what is the difference between radiness pro vs liveliness
		// radiness : whether the pod able to get the request, get the pod is
		// initialized
		// liveliness: keep happening at regular interval,
		// radiness, successfull is then check
		// we can configure the health end point to readiness and liveliness in
		// kubernetes
		// like 3 request success full then returning, 200, any logic we can implement,
		// we should provide configuration and check end point
		// check shallow and indepth check. , status of the application and one is for
		// the dependent services as well.
		//
		// Architecture :
		/*
		 * Control plane: responsible for the API, also work which pod hold work on the
		 * worker load, auto scaling also taken care by control plane. etcd: pod related
		 * and nod related information basically data require to manage cluster, kind of
		 * kubernetese worker node: pods get deployed , pods is the light weight logic
		 * unit, we have splunk forwareder attached to main service container. send to
		 * splunk, pod may have one or more container, there are multiple yaml file,
		 * main deployment.yaml, any new service create a docker c ontainer of it ,
		 * supply deployment use kubectl command , this file basically containe, file
		 * name. how many replica basically how many pod we require, mentioned in
		 * deployment file() configMap: configuration related to environment and
		 * injected in spring properties, use by @value secret: we can also store
		 * secret, we store it our file then we inject them during deployment, HPA:
		 * horizontal pod auto scalilng , scale up and down, 70% > we want new pod scal
		 * up, <70% then reduce. service: can be multiple time, but common, load
		 * balancer, basically use for routing . api1/hello end point routed to diffeent
		 * end point, we can define sto: service mesh use for communication between pod
		 * ingress: is a before the api gateway. we should provide in outing
		 * application. that basicall taken care by.
		 * 
		 * helm chart: its package manager, multiple manifest file(many yaml file), we
		 * can create default configuration, based on the each team requirement modify
		 * this . template: inside this value.yaml file, provide our own value for
		 * specific parameter, 3 replica default, but our requirement in different env,
		 * 5 , prod, dev.yaml. but mostly, 80 to 80% we done.
		 * 
		 * /* mutliple tam may be used for same help chart, we just override, we don't
		 * have to modified with, horizontal pod scaling based on. centralize templat
		 * then every team can utilize this, time saving thing, we can modify 5 or 1o
		 * variable
		 *
		 * 
		 * secret: i don't see secret store in kubernetes cluster, but secret in aws
		 * secret manager in azure, key vault. configMap: if we want to change the value
		 * at the time of run time, if we have separate template, and update the value.
		 * Persistent volume and persistent volumne claim persistent volume, if i am
		 * saying 1 gb of space available, then some one can utilize this pod is die
		 * then there is a piece of data shared withing the pod then this data use data
		 * available in this pod
		 * 
		 * Why doesn't ingress provide , ngnx controller what we can use, just like out
		 * of the box , default controller? Ans. they can be due to secuity, api
		 * gateway, if there is ingress, why there is ingress controller also. - all
		 * component deployment, service, configureMap etc. they are have a generic need
		 * for fix of nature, but when it comes to ingress , that is having wats area,
		 * this is very generic area thats why they haven't include default controller.
		 * 
		 * Persistent Volume: How much space is need Persistent volume claim: how much
		 * space claim or require. they wanted to keep it very loosely couple, you have
		 * to specify, if you don't know the specific, i need 8 gb then i don't care who
		 * will give, deouple the task, one more option - auto allocate volume,
		 * persitent volumne automatically created. one is hard disk drive 2 gb , 32 gb,
		 * i want only 5 gb sdd, kubernetes check minimum volume will attack, against
		 * that claim.
		 * 
		 * Disaster recovery : Elastic kubernetese, thats why there is a option,
		 * geographic we can deploy.
		 * 
		 */
	}
}
