import React, { Component } from 'react'
import EquivalentShuntService from '../services/EquivalentShuntService'

class ListEquivalentShuntComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equivalentShunts: []
        }
        this.addEquivalentShunt = this.addEquivalentShunt.bind(this);
        this.editEquivalentShunt = this.editEquivalentShunt.bind(this);
        this.deleteEquivalentShunt = this.deleteEquivalentShunt.bind(this);
    }

    deleteEquivalentShunt(id){
        EquivalentShuntService.deleteEquivalentShunt(id).then( res => {
            this.setState({equivalentShunts: this.state.equivalentShunts.filter(equivalentShunt => equivalentShunt.equivalentShuntId !== id)});
        });
    }
    viewEquivalentShunt(id){
        this.props.history.push(`/view-equivalentShunt/${id}`);
    }
    editEquivalentShunt(id){
        this.props.history.push(`/add-equivalentShunt/${id}`);
    }

    componentDidMount(){
        EquivalentShuntService.getEquivalentShunts().then((res) => {
            this.setState({ equivalentShunts: res.data});
        });
    }

    addEquivalentShunt(){
        this.props.history.push('/add-equivalentShunt/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquivalentShunt List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquivalentShunt}> Add EquivalentShunt</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> B </th>
                                    <th> G </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equivalentShunts.map(
                                        equivalentShunt => 
                                        <tr key = {equivalentShunt.equivalentShuntId}>
                                             <td> { equivalentShunt.b } </td>
                                             <td> { equivalentShunt.g } </td>
                                             <td>
                                                 <button onClick={ () => this.editEquivalentShunt(equivalentShunt.equivalentShuntId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquivalentShunt(equivalentShunt.equivalentShuntId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquivalentShunt(equivalentShunt.equivalentShuntId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquivalentShuntComponent
