
public class MagicSquare {
	
		static void magicSquare(int n)
		{
			int[][]  matrix = new int[n][n];

			int i = n / 2;
			int j = 0;
			int num = 1;

			while (num <= n*n) {
				if (i == -1 && j == n) {
					j = n - 2;
					i = 0;
				}
				else {
					if (j == n) {
						j = 0;
					}
					if (i < 0) {
						i = n - 1;
					}
				}

				if (matrix[i][j] == 0) {	
					matrix[i][j] = num;
					num++;
					j++;
					i--;
				} else {
					j -= 2;
					i++;
				}

			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					System.out.print(matrix[i][j] + "    ");
				}
				System.out.println();
				System.out.println();
			}
		}

		public static void main(String[] args)
		{
			magicSquare(3);
		}
	}

