import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService'

class ListGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                generatingUnits: []
        }
        this.addGeneratingUnit = this.addGeneratingUnit.bind(this);
        this.editGeneratingUnit = this.editGeneratingUnit.bind(this);
        this.deleteGeneratingUnit = this.deleteGeneratingUnit.bind(this);
    }

    deleteGeneratingUnit(id){
        GeneratingUnitService.deleteGeneratingUnit(id).then( res => {
            this.setState({generatingUnits: this.state.generatingUnits.filter(generatingUnit => generatingUnit.generatingUnitId !== id)});
        });
    }
    viewGeneratingUnit(id){
        this.props.history.push(`/view-generatingUnit/${id}`);
    }
    editGeneratingUnit(id){
        this.props.history.push(`/add-generatingUnit/${id}`);
    }

    componentDidMount(){
        GeneratingUnitService.getGeneratingUnits().then((res) => {
            this.setState({ generatingUnits: res.data});
        });
    }

    addGeneratingUnit(){
        this.props.history.push('/add-generatingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGeneratingUnit}> Add GeneratingUnit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> GenControlSource </th>
                                    <th> GovernorSCD </th>
                                    <th> InitialP </th>
                                    <th> LongPF </th>
                                    <th> MaximumAllowableSpinningReserve </th>
                                    <th> MaxOperatingP </th>
                                    <th> MinOperatingP </th>
                                    <th> NominalP </th>
                                    <th> RatedGrossMaxP </th>
                                    <th> RatedGrossMinP </th>
                                    <th> RatedNetMaxP </th>
                                    <th> ShortPF </th>
                                    <th> StartupCost </th>
                                    <th> TotalEfficiency </th>
                                    <th> VariableCost </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.generatingUnits.map(
                                        generatingUnit => 
                                        <tr key = {generatingUnit.generatingUnitId}>
                                             <td> { generatingUnit.genControlSource } </td>
                                             <td> { generatingUnit.governorSCD } </td>
                                             <td> { generatingUnit.initialP } </td>
                                             <td> { generatingUnit.longPF } </td>
                                             <td> { generatingUnit.maximumAllowableSpinningReserve } </td>
                                             <td> { generatingUnit.maxOperatingP } </td>
                                             <td> { generatingUnit.minOperatingP } </td>
                                             <td> { generatingUnit.nominalP } </td>
                                             <td> { generatingUnit.ratedGrossMaxP } </td>
                                             <td> { generatingUnit.ratedGrossMinP } </td>
                                             <td> { generatingUnit.ratedNetMaxP } </td>
                                             <td> { generatingUnit.shortPF } </td>
                                             <td> { generatingUnit.startupCost } </td>
                                             <td> { generatingUnit.totalEfficiency } </td>
                                             <td> { generatingUnit.variableCost } </td>
                                             <td>
                                                 <button onClick={ () => this.editGeneratingUnit(generatingUnit.generatingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGeneratingUnit(generatingUnit.generatingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGeneratingUnit(generatingUnit.generatingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListGeneratingUnitComponent
