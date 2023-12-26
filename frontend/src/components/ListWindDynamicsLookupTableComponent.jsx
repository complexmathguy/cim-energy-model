import React, { Component } from 'react'
import WindDynamicsLookupTableService from '../services/WindDynamicsLookupTableService'

class ListWindDynamicsLookupTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windDynamicsLookupTables: []
        }
        this.addWindDynamicsLookupTable = this.addWindDynamicsLookupTable.bind(this);
        this.editWindDynamicsLookupTable = this.editWindDynamicsLookupTable.bind(this);
        this.deleteWindDynamicsLookupTable = this.deleteWindDynamicsLookupTable.bind(this);
    }

    deleteWindDynamicsLookupTable(id){
        WindDynamicsLookupTableService.deleteWindDynamicsLookupTable(id).then( res => {
            this.setState({windDynamicsLookupTables: this.state.windDynamicsLookupTables.filter(windDynamicsLookupTable => windDynamicsLookupTable.windDynamicsLookupTableId !== id)});
        });
    }
    viewWindDynamicsLookupTable(id){
        this.props.history.push(`/view-windDynamicsLookupTable/${id}`);
    }
    editWindDynamicsLookupTable(id){
        this.props.history.push(`/add-windDynamicsLookupTable/${id}`);
    }

    componentDidMount(){
        WindDynamicsLookupTableService.getWindDynamicsLookupTables().then((res) => {
            this.setState({ windDynamicsLookupTables: res.data});
        });
    }

    addWindDynamicsLookupTable(){
        this.props.history.push('/add-windDynamicsLookupTable/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindDynamicsLookupTable List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindDynamicsLookupTable}> Add WindDynamicsLookupTable</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Input </th>
                                    <th> LookupTableFunctionType </th>
                                    <th> Output </th>
                                    <th> Sequence </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windDynamicsLookupTables.map(
                                        windDynamicsLookupTable => 
                                        <tr key = {windDynamicsLookupTable.windDynamicsLookupTableId}>
                                             <td> { windDynamicsLookupTable.input } </td>
                                             <td> { windDynamicsLookupTable.lookupTableFunctionType } </td>
                                             <td> { windDynamicsLookupTable.output } </td>
                                             <td> { windDynamicsLookupTable.sequence } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindDynamicsLookupTable(windDynamicsLookupTable.windDynamicsLookupTableId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindDynamicsLookupTable(windDynamicsLookupTable.windDynamicsLookupTableId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindDynamicsLookupTable(windDynamicsLookupTable.windDynamicsLookupTableId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListWindDynamicsLookupTableComponent
