import React, { Component } from 'react'
import PhaseTapChangerTableService from '../services/PhaseTapChangerTableService'

class ListPhaseTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerTables: []
        }
        this.addPhaseTapChangerTable = this.addPhaseTapChangerTable.bind(this);
        this.editPhaseTapChangerTable = this.editPhaseTapChangerTable.bind(this);
        this.deletePhaseTapChangerTable = this.deletePhaseTapChangerTable.bind(this);
    }

    deletePhaseTapChangerTable(id){
        PhaseTapChangerTableService.deletePhaseTapChangerTable(id).then( res => {
            this.setState({phaseTapChangerTables: this.state.phaseTapChangerTables.filter(phaseTapChangerTable => phaseTapChangerTable.phaseTapChangerTableId !== id)});
        });
    }
    viewPhaseTapChangerTable(id){
        this.props.history.push(`/view-phaseTapChangerTable/${id}`);
    }
    editPhaseTapChangerTable(id){
        this.props.history.push(`/add-phaseTapChangerTable/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerTableService.getPhaseTapChangerTables().then((res) => {
            this.setState({ phaseTapChangerTables: res.data});
        });
    }

    addPhaseTapChangerTable(){
        this.props.history.push('/add-phaseTapChangerTable/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerTable List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerTable}> Add PhaseTapChangerTable</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.phaseTapChangerTables.map(
                                        phaseTapChangerTable => 
                                        <tr key = {phaseTapChangerTable.phaseTapChangerTableId}>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerTable(phaseTapChangerTable.phaseTapChangerTableId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerTable(phaseTapChangerTable.phaseTapChangerTableId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerTable(phaseTapChangerTable.phaseTapChangerTableId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerTableComponent
