package com.microsoft.azure.elasticdb.query.logging;

/*
 * Elastic database tools for Azure SQL Database.
 * 
 * Copyright(c) Microsoft Corporation All rights reserved.
 * 
 * This program is made available under the terms of the MIT License. See the LICENSE file in the project root for more information.
 */

/**
 * Defines the possible query execution policies. Purpose: Defines the possible query execution policies Suppression rationale: "Multi" is the
 * spelling we want here.
 */
public enum MultiShardExecutionPolicy {
    /**
     * With the complete results execution policy an unsuccessful execution against any shard leads to all results being discarded and an exception
     * being thrown either by the ExecuteReader method on the command or the Read method on the reader.
     */
    CompleteResults,

    /**
     * A best-effort execution policy that, unlike CompleteResults, tolerates unsuccessful command execution on some (but not all) shards and returns
     * the results of the successful commands. Any errors encountered are returned to the user along with the partial results. The caller can inspect
     * exceptions encountered during execution through the <see cref="MultiShardAggregateException"/> property of <see cref="MultiShardResultSet"/>.
     */
    PartialResults;

}