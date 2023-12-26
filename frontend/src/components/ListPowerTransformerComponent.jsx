import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService'

class ListPowerTransformerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                powerTransformers: []
        }
        this.addPowerTransformer = this.addPowerTransformer.bind(this);
        this.editPowerTransformer = this.editPowerTransformer.bind(this);
        this.deletePowerTransformer = this.deletePowerTransformer.bind(this);
    }

    deletePowerTransformer(id){
        PowerTransformerService.deletePowerTransformer(id).then( res => {
            this.setState({powerTransformers: this.state.powerTransformers.filter(powerTransformer => powerTransformer.powerTransformerId !== id)});
        });
    }
    viewPowerTransformer(id){
        this.props.history.push(`/view-powerTransformer/${id}`);
    }
    editPowerTransformer(id){
        this.props.history.push(`/add-powerTransformer/${id}`);
    }

    componentDidMount(){
        PowerTransformerService.getPowerTransformers().then((res) => {
            this.setState({ powerTransformers: res.data});
        });
    }

    addPowerTransformer(){
        this.props.history.push('/add-powerTransformer/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PowerTransformer List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPowerTransformer}> Add PowerTransformer</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BeforeShCircuitHighestOperatingCurrent </th>
                                    <th> BeforeShCircuitHighestOperatingVoltage </th>
                                    <th> BeforeShortCircuitAnglePf </th>
                                    <th> HighSideMinOperatingU </th>
                                    <th> IsPartOfGeneratorUnit </th>
                                    <th> OperationalValuesConsidered </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.powerTransformers.map(
                                        powerTransformer => 
                                        <tr key = {powerTransformer.powerTransformerId}>
                                             <td> { powerTransformer.beforeShCircuitHighestOperatingCurrent } </td>
                                             <td> { powerTransformer.beforeShCircuitHighestOperatingVoltage } </td>
                                             <td> { powerTransformer.beforeShortCircuitAnglePf } </td>
                                             <td> { powerTransformer.highSideMinOperatingU } </td>
                                             <td> { powerTransformer.isPartOfGeneratorUnit } </td>
                                             <td> { powerTransformer.operationalValuesConsidered } </td>
                                             <td>
                                                 <button onClick={ () => this.editPowerTransformer(powerTransformer.powerTransformerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePowerTransformer(powerTransformer.powerTransformerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPowerTransformer(powerTransformer.powerTransformerId)} className="btn btn-info btn-sm">View </button>
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

export default ListPowerTransformerComponent
