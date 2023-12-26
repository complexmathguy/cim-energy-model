import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService'

class ListGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGASTWDs: []
        }
        this.addGovGASTWD = this.addGovGASTWD.bind(this);
        this.editGovGASTWD = this.editGovGASTWD.bind(this);
        this.deleteGovGASTWD = this.deleteGovGASTWD.bind(this);
    }

    deleteGovGASTWD(id){
        GovGASTWDService.deleteGovGASTWD(id).then( res => {
            this.setState({govGASTWDs: this.state.govGASTWDs.filter(govGASTWD => govGASTWD.govGASTWDId !== id)});
        });
    }
    viewGovGASTWD(id){
        this.props.history.push(`/view-govGASTWD/${id}`);
    }
    editGovGASTWD(id){
        this.props.history.push(`/add-govGASTWD/${id}`);
    }

    componentDidMount(){
        GovGASTWDService.getGovGASTWDs().then((res) => {
            this.setState({ govGASTWDs: res.data});
        });
    }

    addGovGASTWD(){
        this.props.history.push('/add-govGASTWD/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGASTWD List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGASTWD}> Add GovGASTWD</button>
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
                                    <th> Kd </th>
                                    <th> Kdroop </th>
                                    <th> Kf </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Mwbase </th>
                                    <th> T </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> Tc </th>
                                    <th> Tcd </th>
                                    <th> Td </th>
                                    <th> Tf </th>
                                    <th> Tmax </th>
                                    <th> Tmin </th>
                                    <th> Tr </th>
                                    <th> Trate </th>
                                    <th> Tt </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govGASTWDs.map(
                                        govGASTWD => 
                                        <tr key = {govGASTWD.govGASTWDId}>
                                             <td> { govGASTWD.a } </td>
                                             <td> { govGASTWD.af1 } </td>
                                             <td> { govGASTWD.af2 } </td>
                                             <td> { govGASTWD.b } </td>
                                             <td> { govGASTWD.bf1 } </td>
                                             <td> { govGASTWD.bf2 } </td>
                                             <td> { govGASTWD.c } </td>
                                             <td> { govGASTWD.cf2 } </td>
                                             <td> { govGASTWD.ecr } </td>
                                             <td> { govGASTWD.etd } </td>
                                             <td> { govGASTWD.k3 } </td>
                                             <td> { govGASTWD.k4 } </td>
                                             <td> { govGASTWD.k5 } </td>
                                             <td> { govGASTWD.k6 } </td>
                                             <td> { govGASTWD.kd } </td>
                                             <td> { govGASTWD.kdroop } </td>
                                             <td> { govGASTWD.kf } </td>
                                             <td> { govGASTWD.ki } </td>
                                             <td> { govGASTWD.kp } </td>
                                             <td> { govGASTWD.mwbase } </td>
                                             <td> { govGASTWD.t } </td>
                                             <td> { govGASTWD.t3 } </td>
                                             <td> { govGASTWD.t4 } </td>
                                             <td> { govGASTWD.t5 } </td>
                                             <td> { govGASTWD.tc } </td>
                                             <td> { govGASTWD.tcd } </td>
                                             <td> { govGASTWD.td } </td>
                                             <td> { govGASTWD.tf } </td>
                                             <td> { govGASTWD.tmax } </td>
                                             <td> { govGASTWD.tmin } </td>
                                             <td> { govGASTWD.tr } </td>
                                             <td> { govGASTWD.trate } </td>
                                             <td> { govGASTWD.tt } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovGASTWD(govGASTWD.govGASTWDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGASTWD(govGASTWD.govGASTWDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGASTWD(govGASTWD.govGASTWDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGASTWDComponent
