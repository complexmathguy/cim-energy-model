import React, { Component } from 'react'
import PssSKService from '../services/PssSKService'

class ListPssSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssSKs: []
        }
        this.addPssSK = this.addPssSK.bind(this);
        this.editPssSK = this.editPssSK.bind(this);
        this.deletePssSK = this.deletePssSK.bind(this);
    }

    deletePssSK(id){
        PssSKService.deletePssSK(id).then( res => {
            this.setState({pssSKs: this.state.pssSKs.filter(pssSK => pssSK.pssSKId !== id)});
        });
    }
    viewPssSK(id){
        this.props.history.push(`/view-pssSK/${id}`);
    }
    editPssSK(id){
        this.props.history.push(`/add-pssSK/${id}`);
    }

    componentDidMount(){
        PssSKService.getPssSKs().then((res) => {
            this.setState({ pssSKs: res.data});
        });
    }

    addPssSK(){
        this.props.history.push('/add-pssSK/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssSK List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssSK}> Add PssSK</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> K3 </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> Vsmax </th>
                                    <th> Vsmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssSKs.map(
                                        pssSK => 
                                        <tr key = {pssSK.pssSKId}>
                                             <td> { pssSK.k1 } </td>
                                             <td> { pssSK.k2 } </td>
                                             <td> { pssSK.k3 } </td>
                                             <td> { pssSK.t1 } </td>
                                             <td> { pssSK.t2 } </td>
                                             <td> { pssSK.t3 } </td>
                                             <td> { pssSK.t4 } </td>
                                             <td> { pssSK.t5 } </td>
                                             <td> { pssSK.t6 } </td>
                                             <td> { pssSK.vsmax } </td>
                                             <td> { pssSK.vsmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssSK(pssSK.pssSKId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssSK(pssSK.pssSKId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssSK(pssSK.pssSKId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssSKComponent
