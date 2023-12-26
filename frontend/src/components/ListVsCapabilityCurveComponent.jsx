import React, { Component } from 'react'
import VsCapabilityCurveService from '../services/VsCapabilityCurveService'

class ListVsCapabilityCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                vsCapabilityCurves: []
        }
        this.addVsCapabilityCurve = this.addVsCapabilityCurve.bind(this);
        this.editVsCapabilityCurve = this.editVsCapabilityCurve.bind(this);
        this.deleteVsCapabilityCurve = this.deleteVsCapabilityCurve.bind(this);
    }

    deleteVsCapabilityCurve(id){
        VsCapabilityCurveService.deleteVsCapabilityCurve(id).then( res => {
            this.setState({vsCapabilityCurves: this.state.vsCapabilityCurves.filter(vsCapabilityCurve => vsCapabilityCurve.vsCapabilityCurveId !== id)});
        });
    }
    viewVsCapabilityCurve(id){
        this.props.history.push(`/view-vsCapabilityCurve/${id}`);
    }
    editVsCapabilityCurve(id){
        this.props.history.push(`/add-vsCapabilityCurve/${id}`);
    }

    componentDidMount(){
        VsCapabilityCurveService.getVsCapabilityCurves().then((res) => {
            this.setState({ vsCapabilityCurves: res.data});
        });
    }

    addVsCapabilityCurve(){
        this.props.history.push('/add-vsCapabilityCurve/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VsCapabilityCurve List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVsCapabilityCurve}> Add VsCapabilityCurve</button>
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
                                    this.state.vsCapabilityCurves.map(
                                        vsCapabilityCurve => 
                                        <tr key = {vsCapabilityCurve.vsCapabilityCurveId}>
                                             <td>
                                                 <button onClick={ () => this.editVsCapabilityCurve(vsCapabilityCurve.vsCapabilityCurveId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVsCapabilityCurve(vsCapabilityCurve.vsCapabilityCurveId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVsCapabilityCurve(vsCapabilityCurve.vsCapabilityCurveId)} className="btn btn-info btn-sm">View </button>
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

export default ListVsCapabilityCurveComponent
