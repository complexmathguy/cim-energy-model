import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService'

class ListEquivalentBranchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equivalentBranchs: []
        }
        this.addEquivalentBranch = this.addEquivalentBranch.bind(this);
        this.editEquivalentBranch = this.editEquivalentBranch.bind(this);
        this.deleteEquivalentBranch = this.deleteEquivalentBranch.bind(this);
    }

    deleteEquivalentBranch(id){
        EquivalentBranchService.deleteEquivalentBranch(id).then( res => {
            this.setState({equivalentBranchs: this.state.equivalentBranchs.filter(equivalentBranch => equivalentBranch.equivalentBranchId !== id)});
        });
    }
    viewEquivalentBranch(id){
        this.props.history.push(`/view-equivalentBranch/${id}`);
    }
    editEquivalentBranch(id){
        this.props.history.push(`/add-equivalentBranch/${id}`);
    }

    componentDidMount(){
        EquivalentBranchService.getEquivalentBranchs().then((res) => {
            this.setState({ equivalentBranchs: res.data});
        });
    }

    addEquivalentBranch(){
        this.props.history.push('/add-equivalentBranch/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquivalentBranch List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquivalentBranch}> Add EquivalentBranch</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> NegativeR12 </th>
                                    <th> NegativeR21 </th>
                                    <th> NegativeX12 </th>
                                    <th> NegativeX21 </th>
                                    <th> PositiveR12 </th>
                                    <th> PositiveR21 </th>
                                    <th> PositiveX12 </th>
                                    <th> PositiveX21 </th>
                                    <th> R </th>
                                    <th> R21 </th>
                                    <th> X </th>
                                    <th> X21 </th>
                                    <th> ZeroR12 </th>
                                    <th> ZeroR21 </th>
                                    <th> ZeroX12 </th>
                                    <th> ZeroX21 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equivalentBranchs.map(
                                        equivalentBranch => 
                                        <tr key = {equivalentBranch.equivalentBranchId}>
                                             <td> { equivalentBranch.negativeR12 } </td>
                                             <td> { equivalentBranch.negativeR21 } </td>
                                             <td> { equivalentBranch.negativeX12 } </td>
                                             <td> { equivalentBranch.negativeX21 } </td>
                                             <td> { equivalentBranch.positiveR12 } </td>
                                             <td> { equivalentBranch.positiveR21 } </td>
                                             <td> { equivalentBranch.positiveX12 } </td>
                                             <td> { equivalentBranch.positiveX21 } </td>
                                             <td> { equivalentBranch.r } </td>
                                             <td> { equivalentBranch.r21 } </td>
                                             <td> { equivalentBranch.x } </td>
                                             <td> { equivalentBranch.x21 } </td>
                                             <td> { equivalentBranch.zeroR12 } </td>
                                             <td> { equivalentBranch.zeroR21 } </td>
                                             <td> { equivalentBranch.zeroX12 } </td>
                                             <td> { equivalentBranch.zeroX21 } </td>
                                             <td>
                                                 <button onClick={ () => this.editEquivalentBranch(equivalentBranch.equivalentBranchId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquivalentBranch(equivalentBranch.equivalentBranchId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquivalentBranch(equivalentBranch.equivalentBranchId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquivalentBranchComponent
