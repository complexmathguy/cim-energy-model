import React, { Component } from 'react'
import ReactanceService from '../services/ReactanceService'

class ListReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                reactances: []
        }
        this.addReactance = this.addReactance.bind(this);
        this.editReactance = this.editReactance.bind(this);
        this.deleteReactance = this.deleteReactance.bind(this);
    }

    deleteReactance(id){
        ReactanceService.deleteReactance(id).then( res => {
            this.setState({reactances: this.state.reactances.filter(reactance => reactance.reactanceId !== id)});
        });
    }
    viewReactance(id){
        this.props.history.push(`/view-reactance/${id}`);
    }
    editReactance(id){
        this.props.history.push(`/add-reactance/${id}`);
    }

    componentDidMount(){
        ReactanceService.getReactances().then((res) => {
            this.setState({ reactances: res.data});
        });
    }

    addReactance(){
        this.props.history.push('/add-reactance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Reactance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addReactance}> Add Reactance</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.reactances.map(
                                        reactance => 
                                        <tr key = {reactance.reactanceId}>
                                             <td> { reactance.multiplier } </td>
                                             <td> { reactance.unit } </td>
                                             <td> { reactance.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editReactance(reactance.reactanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteReactance(reactance.reactanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewReactance(reactance.reactanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListReactanceComponent
