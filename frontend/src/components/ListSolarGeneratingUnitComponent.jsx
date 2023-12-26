import React, { Component } from 'react'
import SolarGeneratingUnitService from '../services/SolarGeneratingUnitService'

class ListSolarGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                solarGeneratingUnits: []
        }
        this.addSolarGeneratingUnit = this.addSolarGeneratingUnit.bind(this);
        this.editSolarGeneratingUnit = this.editSolarGeneratingUnit.bind(this);
        this.deleteSolarGeneratingUnit = this.deleteSolarGeneratingUnit.bind(this);
    }

    deleteSolarGeneratingUnit(id){
        SolarGeneratingUnitService.deleteSolarGeneratingUnit(id).then( res => {
            this.setState({solarGeneratingUnits: this.state.solarGeneratingUnits.filter(solarGeneratingUnit => solarGeneratingUnit.solarGeneratingUnitId !== id)});
        });
    }
    viewSolarGeneratingUnit(id){
        this.props.history.push(`/view-solarGeneratingUnit/${id}`);
    }
    editSolarGeneratingUnit(id){
        this.props.history.push(`/add-solarGeneratingUnit/${id}`);
    }

    componentDidMount(){
        SolarGeneratingUnitService.getSolarGeneratingUnits().then((res) => {
            this.setState({ solarGeneratingUnits: res.data});
        });
    }

    addSolarGeneratingUnit(){
        this.props.history.push('/add-solarGeneratingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SolarGeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSolarGeneratingUnit}> Add SolarGeneratingUnit</button>
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
                                    this.state.solarGeneratingUnits.map(
                                        solarGeneratingUnit => 
                                        <tr key = {solarGeneratingUnit.solarGeneratingUnitId}>
                                             <td>
                                                 <button onClick={ () => this.editSolarGeneratingUnit(solarGeneratingUnit.solarGeneratingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSolarGeneratingUnit(solarGeneratingUnit.solarGeneratingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSolarGeneratingUnit(solarGeneratingUnit.solarGeneratingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListSolarGeneratingUnitComponent
