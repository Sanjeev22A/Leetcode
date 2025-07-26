# Write your MySQL query statement below
with temp_cte as(
    select sample_id,dna_sequence,species,
    case
    when dna_sequence  like "ATG%" then 1
    else 0
    end as has_start,
    case when dna_sequence  like "%TAA" or dna_sequence like "%TAG" or dna_sequence  like "%TGA" then 1
    else 0
    end as has_stop,
    case when dna_sequence like "%ATAT%" then 1
    else 0
    end as has_atat,
    case when dna_sequence like "%GGG%" then 1
    else 0
    end as has_ggg
    from samples
)
select * from temp_cte