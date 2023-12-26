import React, { Component } from 'react'
import HydroGeneratingUnitService from '../services/HydroGeneratingUnitService'

class ListHydroGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                hydroGeneratingUnits: []
        }
        this.addHydroGeneratingUnit = this.addHydroGeneratingUnit.bind(this);
        this.editHydroGeneratingUnit = this.editHydroGeneratingUnit.bind(this);
        this.deleteHydroGeneratingUnit = this.deleteHydroGeneratingUnit.bind(this);
    }

    deleteHydroGeneratingUnit(id){
        HydroGeneratingUnitService.deleteHydroGeneratingUnit(id).then( res => {
            this.setState({hydroGeneratingUnits: this.state.hydroGeneratingUnits.filter(hydroGeneratingUnit => hydroGeneratingUnit.hydroGeneratingUnitId !== id)});
        });
    }
    viewHydroGeneratingUnit(id){
        this.props.history.push(`/view-hydroGeneratingUnit/${id}`);
    }
    editHydroGeneratingUnit(id){
        this.props.history.push(`/add-hydroGeneratingUnit/${id}`);
    }

    componentDidMount(){
        HydroGeneratingUnitService.getHydroGeneratingUnits().then((res) => {
            this.setState({ hydroGeneratingUnits: res.data});
        });
    }

    addHydroGeneratingUnit(){
        this.props.history.push('/add-hydroGeneratingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">HydroGeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addHydroGeneratingUnit}> Add HydroGeneratingUnit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> EnergyConversionCapability </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.hydroGeneratingUnits.map(
                                        hydroGeneratingUnit => 
                                        <tr key = {hydroGeneratingUnit.hydroGeneratingUnitId}>
                                             <td> { hydroGeneratingUnit.energyConversionCapability } </td>
                                             <td>
                                                 <button onClick={ () => this.editHydroGeneratingUnit(hydroGeneratingUnit.hydroGeneratingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteHydroGeneratingUnit(hydroGeneratingUnit.hydroGeneratingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewHydroGeneratingUnit(hydroGeneratingUnit.hydroGeneratingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListHydroGeneratingUnitComponent
