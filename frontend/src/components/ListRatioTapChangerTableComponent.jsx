import React, { Component } from 'react'
import RatioTapChangerTableService from '../services/RatioTapChangerTableService'

class ListRatioTapChangerTableComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                ratioTapChangerTables: []
        }
        this.addRatioTapChangerTable = this.addRatioTapChangerTable.bind(this);
        this.editRatioTapChangerTable = this.editRatioTapChangerTable.bind(this);
        this.deleteRatioTapChangerTable = this.deleteRatioTapChangerTable.bind(this);
    }

    deleteRatioTapChangerTable(id){
        RatioTapChangerTableService.deleteRatioTapChangerTable(id).then( res => {
            this.setState({ratioTapChangerTables: this.state.ratioTapChangerTables.filter(ratioTapChangerTable => ratioTapChangerTable.ratioTapChangerTableId !== id)});
        });
    }
    viewRatioTapChangerTable(id){
        this.props.history.push(`/view-ratioTapChangerTable/${id}`);
    }
    editRatioTapChangerTable(id){
        this.props.history.push(`/add-ratioTapChangerTable/${id}`);
    }

    componentDidMount(){
        RatioTapChangerTableService.getRatioTapChangerTables().then((res) => {
            this.setState({ ratioTapChangerTables: res.data});
        });
    }

    addRatioTapChangerTable(){
        this.props.history.push('/add-ratioTapChangerTable/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RatioTapChangerTable List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRatioTapChangerTable}> Add RatioTapChangerTable</button>
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
                                    this.state.ratioTapChangerTables.map(
                                        ratioTapChangerTable => 
                                        <tr key = {ratioTapChangerTable.ratioTapChangerTableId}>
                                             <td>
                                                 <button onClick={ () => this.editRatioTapChangerTable(ratioTapChangerTable.ratioTapChangerTableId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRatioTapChangerTable(ratioTapChangerTable.ratioTapChangerTableId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRatioTapChangerTable(ratioTapChangerTable.ratioTapChangerTableId)} className="btn btn-info btn-sm">View </button>
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

export default ListRatioTapChangerTableComponent
