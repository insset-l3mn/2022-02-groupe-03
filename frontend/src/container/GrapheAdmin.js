import React from 'react';
import ReactFlow from 'react-flow-renderer';

export default function GrapheAdmin() {
    const elements = [
        {
            id: '1',
            type: 'input', // input node
            data: { label: 'Langues Étrangères' },
            position: { x: 250, y: 25 },
        },
        // default node
        {
            id: '2',
            type: 'input', // input node
            data: { label: 'Informatique' },
            position: { x: 250, y: 125 },
        },
        {
            id: '3',
            type: 'output', // output node
            data: { label: 'Médical' },
            position: { x: 250, y: 175 },
        },
        {
            id: '4',
            type: 'output', // output node
            data: { label: 'Histoire' },
            position: { x: 250, y: 75 },
        },
        // animated edge
    ];

    return(
        <div style={{ height: 300 }}>
            <ReactFlow elements={elements} />
        </div>
    );
}