import React, { Component } from 'react'
import PerLengthDCLineParameterService from '../services/PerLengthDCLineParameterService'

class ListPerLengthDCLineParameterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                perLengthDCLineParameters: []
        }
        this.addPerLengthDCLineParameter = this.addPerLengthDCLineParameter.bind(this);
        this.editPerLengthDCLineParameter = this.editPerLengthDCLineParameter.bind(this);
        this.deletePerLengthDCLineParameter = this.deletePerLengthDCLineParameter.bind(this);
    }

    deletePerLengthDCLineParameter(id){
        PerLengthDCLineParameterService.deletePerLengthDCLineParameter(id).then( res => {
            this.setState({perLengthDCLineParameters: this.state.perLengthDCLineParameters.filter(perLengthDCLineParameter => perLengthDCLineParameter.perLengthDCLineParameterId !== id)});
        });
    }
    viewPerLengthDCLineParameter(id){
        this.props.history.push(`/view-perLengthDCLineParameter/${id}`);
    }
    editPerLengthDCLineParameter(id){
        this.props.history.push(`/add-perLengthDCLineParameter/${id}`);
    }

    componentDidMount(){
        PerLengthDCLineParameterService.getPerLengthDCLineParameters().then((res) => {
            this.setState({ perLengthDCLineParameters: res.data});
        });
    }

    addPerLengthDCLineParameter(){
        this.props.history.push('/add-perLengthDCLineParameter/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PerLengthDCLineParameter List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPerLengthDCLineParameter}> Add PerLengthDCLineParameter</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Capacitance </th>
                                    <th> Inductance </th>
                                    <th> Resistance </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.perLengthDCLineParameters.map(
                                        perLengthDCLineParameter => 
                                        <tr key = {perLengthDCLineParameter.perLengthDCLineParameterId}>
                                             <td> { perLengthDCLineParameter.capacitance } </td>
                                             <td> { perLengthDCLineParameter.inductance } </td>
                                             <td> { perLengthDCLineParameter.resistance } </td>
                                             <td>
                                                 <button onClick={ () => this.editPerLengthDCLineParameter(perLengthDCLineParameter.perLengthDCLineParameterId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePerLengthDCLineParameter(perLengthDCLineParameter.perLengthDCLineParameterId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPerLengthDCLineParameter(perLengthDCLineParameter.perLengthDCLineParameterId)} className="btn btn-info btn-sm">View </button>
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

export default ListPerLengthDCLineParameterComponent
