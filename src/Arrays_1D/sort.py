# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#Metodos de ordenamiento y de búsqueda implementados con el plugin de python

def insertionSort(A):
    for i in range(1, len(A)):
        temp = A[i]
        indexHole = i
        while indexHole > 0 and A[indexHole-1] > temp:
            A[indexHole] = A[indexHole-1]
            indexHole -= 1       
        A[indexHole] = temp
    return A

def quickSort(A, first, last):
    i = first
    j = last
    pivot = (A[i] + A[j]) /2
    while i<j:
        while A[i] < pivot:
            i+=1
        while A[j] > pivot:
            j-=1
        if i<=j:
            temp=A[j] 
            A[j]=A[i]
            A[i]=temp
            i+=1
            j-=1
    if first < j:
        A = quickSort(A, first, j)
    if last > i:
        A = quickSort(A, i, last)
    return A

def binarySearch(sorted, x):
    lowerBound = 0
    upperBound = len(sorted) - 1
    index = -1
    while lowerBound < upperBound:
        middlePoint = (lowerBound + upperBound) / 2
        if x == sorted[middlePoint]:
            index = middlePoint;
            break
        else:
            if x < middlePoint:
                upperBound = middlePoint - 1
            else:
                lowerBound = middlePoint + 1
        
        
    if lowerBound == upperBound and sorted[lowerBound] == x:
        index = lowerBound;
    return index   

def binarySearch_2(sorted, x, lB, uB):
    middlePoint = (lB + uB)/2;
    if lB == uB:
        if sorted[middlePoint] == x:
            return middlePoint;  
        else:
            return -1;
    else:
        if sorted[middlePoint] == x:
            return middlePoint
        else:
            if x < sorted[middlePoint]:
                return binarySearch_2(sorted, x, lB, middlePoint)
            else:
                return binarySearch_2(sorted, x, middlePoint +1, uB)
    
def interpolationSearch(sorted, x):
    limiteInf = 0
    limiteSup = len(sorted) - 1
    index = -1  
    while limiteInf < limiteSup:
        puntoMedio = limiteInf + (((limiteSup - limiteInf) / sorted[limiteSup]-sorted[limiteInf]) * (x - sorted[limiteInf]))
        if x == sorted[puntoMedio]:
            index = puntoMedio
            break
        else:
            if x < sorted[puntoMedio]:
                limiteSup = puntoMedio-1
            else:
                limiteInf = puntoMedio+1
            
    if limiteInf == limiteSup and sorted[limiteInf] == x:
        index = limiteInf
    return index
    

C = [9,6,1,7,2,5,3,1]
print quickSort(C, 0, 7)

D = [3,0,5,6,2,1,4,9]
print insertionSort(D)

print binarySearch(D, 9)
print binarySearch_2(D, 9, 0, 7)
