import React, { Component } from 'react'
import ReactiveCapabilityCurveService from '../services/ReactiveCapabilityCurveService'

class ListReactiveCapabilityCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                reactiveCapabilityCurves: []
        }
        this.addReactiveCapabilityCurve = this.addReactiveCapabilityCurve.bind(this);
        this.editReactiveCapabilityCurve = this.editReactiveCapabilityCurve.bind(this);
        this.deleteReactiveCapabilityCurve = this.deleteReactiveCapabilityCurve.bind(this);
    }

    deleteReactiveCapabilityCurve(id){
        ReactiveCapabilityCurveService.deleteReactiveCapabilityCurve(id).then( res => {
            this.setState({reactiveCapabilityCurves: this.state.reactiveCapabilityCurves.filter(reactiveCapabilityCurve => reactiveCapabilityCurve.reactiveCapabilityCurveId !== id)});
        });
    }
    viewReactiveCapabilityCurve(id){
        this.props.history.push(`/view-reactiveCapabilityCurve/${id}`);
    }
    editReactiveCapabilityCurve(id){
        this.props.history.push(`/add-reactiveCapabilityCurve/${id}`);
    }

    componentDidMount(){
        ReactiveCapabilityCurveService.getReactiveCapabilityCurves().then((res) => {
            this.setState({ reactiveCapabilityCurves: res.data});
        });
    }

    addReactiveCapabilityCurve(){
        this.props.history.push('/add-reactiveCapabilityCurve/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ReactiveCapabilityCurve List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addReactiveCapabilityCurve}> Add ReactiveCapabilityCurve</button>
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
                                    this.state.reactiveCapabilityCurves.map(
                                        reactiveCapabilityCurve => 
                                        <tr key = {reactiveCapabilityCurve.reactiveCapabilityCurveId}>
                                             <td>
                                                 <button onClick={ () => this.editReactiveCapabilityCurve(reactiveCapabilityCurve.reactiveCapabilityCurveId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteReactiveCapabilityCurve(reactiveCapabilityCurve.reactiveCapabilityCurveId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewReactiveCapabilityCurve(reactiveCapabilityCurve.reactiveCapabilityCurveId)} className="btn btn-info btn-sm">View </button>
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

export default ListReactiveCapabilityCurveComponent
