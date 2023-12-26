import React, { Component } from 'react'
import DCConverterUnitService from '../services/DCConverterUnitService'

class ListDCConverterUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCConverterUnits: []
        }
        this.addDCConverterUnit = this.addDCConverterUnit.bind(this);
        this.editDCConverterUnit = this.editDCConverterUnit.bind(this);
        this.deleteDCConverterUnit = this.deleteDCConverterUnit.bind(this);
    }

    deleteDCConverterUnit(id){
        DCConverterUnitService.deleteDCConverterUnit(id).then( res => {
            this.setState({dCConverterUnits: this.state.dCConverterUnits.filter(dCConverterUnit => dCConverterUnit.dCConverterUnitId !== id)});
        });
    }
    viewDCConverterUnit(id){
        this.props.history.push(`/view-dCConverterUnit/${id}`);
    }
    editDCConverterUnit(id){
        this.props.history.push(`/add-dCConverterUnit/${id}`);
    }

    componentDidMount(){
        DCConverterUnitService.getDCConverterUnits().then((res) => {
            this.setState({ dCConverterUnits: res.data});
        });
    }

    addDCConverterUnit(){
        this.props.history.push('/add-dCConverterUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCConverterUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCConverterUnit}> Add DCConverterUnit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> OperationMode </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dCConverterUnits.map(
                                        dCConverterUnit => 
                                        <tr key = {dCConverterUnit.dCConverterUnitId}>
                                             <td> { dCConverterUnit.operationMode } </td>
                                             <td>
                                                 <button onClick={ () => this.editDCConverterUnit(dCConverterUnit.dCConverterUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCConverterUnit(dCConverterUnit.dCConverterUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCConverterUnit(dCConverterUnit.dCConverterUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCConverterUnitComponent
