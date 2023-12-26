import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service'

class ListGovGAST2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGAST2s: []
        }
        this.addGovGAST2 = this.addGovGAST2.bind(this);
        this.editGovGAST2 = this.editGovGAST2.bind(this);
        this.deleteGovGAST2 = this.deleteGovGAST2.bind(this);
    }

    deleteGovGAST2(id){
        GovGAST2Service.deleteGovGAST2(id).then( res => {
            this.setState({govGAST2s: this.state.govGAST2s.filter(govGAST2 => govGAST2.govGAST2Id !== id)});
        });
    }
    viewGovGAST2(id){
        this.props.history.push(`/view-govGAST2/${id}`);
    }
    editGovGAST2(id){
        this.props.history.push(`/add-govGAST2/${id}`);
    }

    componentDidMount(){
        GovGAST2Service.getGovGAST2s().then((res) => {
            this.setState({ govGAST2s: res.data});
        });
    }

    addGovGAST2(){
        this.props.history.push('/add-govGAST2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST2}> Add GovGAST2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A </th>
                                    <th> Af1 </th>
                                    <th> Af2 </th>
                                    <th> B </th>
                                    <th> Bf1 </th>
                                    <th> Bf2 </th>
                                    <th> C </th>
                                    <th> Cf2 </th>
                                    <th> Ecr </th>
                                    <th> Etd </th>
                                    <th> K3 </th>
                                    <th> K4 </th>
                                    <th> K5 </th>
                                    <th> K6 </th>
                                    <th> Kf </th>
                                    <th> Mwbase </th>
                                    <th> T </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> Tc </th>
                                    <th> Tcd </th>
                                    <th> Tf </th>
                                    <th> Tmax </th>
                                    <th> Tmin </th>
                                    <th> Tr </th>
                                    <th> Trate </th>
                                    <th> Tt </th>
                                    <th> W </th>
                                    <th> X </th>
                                    <th> Y </th>
                                    <th> Z </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govGAST2s.map(
                                        govGAST2 => 
                                        <tr key = {govGAST2.govGAST2Id}>
                                             <td> { govGAST2.a } </td>
                                             <td> { govGAST2.af1 } </td>
                                             <td> { govGAST2.af2 } </td>
                                             <td> { govGAST2.b } </td>
                                             <td> { govGAST2.bf1 } </td>
                                             <td> { govGAST2.bf2 } </td>
                                             <td> { govGAST2.c } </td>
                                             <td> { govGAST2.cf2 } </td>
                                             <td> { govGAST2.ecr } </td>
                                             <td> { govGAST2.etd } </td>
                                             <td> { govGAST2.k3 } </td>
                                             <td> { govGAST2.k4 } </td>
                                             <td> { govGAST2.k5 } </td>
                                             <td> { govGAST2.k6 } </td>
                                             <td> { govGAST2.kf } </td>
                                             <td> { govGAST2.mwbase } </td>
                                             <td> { govGAST2.t } </td>
                                             <td> { govGAST2.t3 } </td>
                                             <td> { govGAST2.t4 } </td>
                                             <td> { govGAST2.t5 } </td>
                                             <td> { govGAST2.tc } </td>
                                             <td> { govGAST2.tcd } </td>
                                             <td> { govGAST2.tf } </td>
                                             <td> { govGAST2.tmax } </td>
                                             <td> { govGAST2.tmin } </td>
                                             <td> { govGAST2.tr } </td>
                                             <td> { govGAST2.trate } </td>
                                             <td> { govGAST2.tt } </td>
                                             <td> { govGAST2.w } </td>
                                             <td> { govGAST2.x } </td>
                                             <td> { govGAST2.y } </td>
                                             <td> { govGAST2.z } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST2(govGAST2.govGAST2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST2(govGAST2.govGAST2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST2(govGAST2.govGAST2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGAST2Component
