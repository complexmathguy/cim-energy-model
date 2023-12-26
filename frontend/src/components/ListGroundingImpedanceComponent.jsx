import React, { Component } from 'react'
import GroundingImpedanceService from '../services/GroundingImpedanceService'

class ListGroundingImpedanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                groundingImpedances: []
        }
        this.addGroundingImpedance = this.addGroundingImpedance.bind(this);
        this.editGroundingImpedance = this.editGroundingImpedance.bind(this);
        this.deleteGroundingImpedance = this.deleteGroundingImpedance.bind(this);
    }

    deleteGroundingImpedance(id){
        GroundingImpedanceService.deleteGroundingImpedance(id).then( res => {
            this.setState({groundingImpedances: this.state.groundingImpedances.filter(groundingImpedance => groundingImpedance.groundingImpedanceId !== id)});
        });
    }
    viewGroundingImpedance(id){
        this.props.history.push(`/view-groundingImpedance/${id}`);
    }
    editGroundingImpedance(id){
        this.props.history.push(`/add-groundingImpedance/${id}`);
    }

    componentDidMount(){
        GroundingImpedanceService.getGroundingImpedances().then((res) => {
            this.setState({ groundingImpedances: res.data});
        });
    }

    addGroundingImpedance(){
        this.props.history.push('/add-groundingImpedance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GroundingImpedance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGroundingImpedance}> Add GroundingImpedance</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> X </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.groundingImpedances.map(
                                        groundingImpedance => 
                                        <tr key = {groundingImpedance.groundingImpedanceId}>
                                             <td> { groundingImpedance.x } </td>
                                             <td>
                                                 <button onClick={ () => this.editGroundingImpedance(groundingImpedance.groundingImpedanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGroundingImpedance(groundingImpedance.groundingImpedanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGroundingImpedance(groundingImpedance.groundingImpedanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListGroundingImpedanceComponent
