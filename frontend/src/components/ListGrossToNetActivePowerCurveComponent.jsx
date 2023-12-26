import React, { Component } from 'react'
import GrossToNetActivePowerCurveService from '../services/GrossToNetActivePowerCurveService'

class ListGrossToNetActivePowerCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                grossToNetActivePowerCurves: []
        }
        this.addGrossToNetActivePowerCurve = this.addGrossToNetActivePowerCurve.bind(this);
        this.editGrossToNetActivePowerCurve = this.editGrossToNetActivePowerCurve.bind(this);
        this.deleteGrossToNetActivePowerCurve = this.deleteGrossToNetActivePowerCurve.bind(this);
    }

    deleteGrossToNetActivePowerCurve(id){
        GrossToNetActivePowerCurveService.deleteGrossToNetActivePowerCurve(id).then( res => {
            this.setState({grossToNetActivePowerCurves: this.state.grossToNetActivePowerCurves.filter(grossToNetActivePowerCurve => grossToNetActivePowerCurve.grossToNetActivePowerCurveId !== id)});
        });
    }
    viewGrossToNetActivePowerCurve(id){
        this.props.history.push(`/view-grossToNetActivePowerCurve/${id}`);
    }
    editGrossToNetActivePowerCurve(id){
        this.props.history.push(`/add-grossToNetActivePowerCurve/${id}`);
    }

    componentDidMount(){
        GrossToNetActivePowerCurveService.getGrossToNetActivePowerCurves().then((res) => {
            this.setState({ grossToNetActivePowerCurves: res.data});
        });
    }

    addGrossToNetActivePowerCurve(){
        this.props.history.push('/add-grossToNetActivePowerCurve/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GrossToNetActivePowerCurve List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGrossToNetActivePowerCurve}> Add GrossToNetActivePowerCurve</button>
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
                                    this.state.grossToNetActivePowerCurves.map(
                                        grossToNetActivePowerCurve => 
                                        <tr key = {grossToNetActivePowerCurve.grossToNetActivePowerCurveId}>
                                             <td>
                                                 <button onClick={ () => this.editGrossToNetActivePowerCurve(grossToNetActivePowerCurve.grossToNetActivePowerCurveId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGrossToNetActivePowerCurve(grossToNetActivePowerCurve.grossToNetActivePowerCurveId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGrossToNetActivePowerCurve(grossToNetActivePowerCurve.grossToNetActivePowerCurveId)} className="btn btn-info btn-sm">View </button>
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

export default ListGrossToNetActivePowerCurveComponent
