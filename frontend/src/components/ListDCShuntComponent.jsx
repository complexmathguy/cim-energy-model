import React, { Component } from 'react'
import DCShuntService from '../services/DCShuntService'

class ListDCShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCShunts: []
        }
        this.addDCShunt = this.addDCShunt.bind(this);
        this.editDCShunt = this.editDCShunt.bind(this);
        this.deleteDCShunt = this.deleteDCShunt.bind(this);
    }

    deleteDCShunt(id){
        DCShuntService.deleteDCShunt(id).then( res => {
            this.setState({dCShunts: this.state.dCShunts.filter(dCShunt => dCShunt.dCShuntId !== id)});
        });
    }
    viewDCShunt(id){
        this.props.history.push(`/view-dCShunt/${id}`);
    }
    editDCShunt(id){
        this.props.history.push(`/add-dCShunt/${id}`);
    }

    componentDidMount(){
        DCShuntService.getDCShunts().then((res) => {
            this.setState({ dCShunts: res.data});
        });
    }

    addDCShunt(){
        this.props.history.push('/add-dCShunt/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCShunt List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCShunt}> Add DCShunt</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Capacitance </th>
                                    <th> RatedUdc </th>
                                    <th> Resistance </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dCShunts.map(
                                        dCShunt => 
                                        <tr key = {dCShunt.dCShuntId}>
                                             <td> { dCShunt.capacitance } </td>
                                             <td> { dCShunt.ratedUdc } </td>
                                             <td> { dCShunt.resistance } </td>
                                             <td>
                                                 <button onClick={ () => this.editDCShunt(dCShunt.dCShuntId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCShunt(dCShunt.dCShuntId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCShunt(dCShunt.dCShuntId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCShuntComponent
