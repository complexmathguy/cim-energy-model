import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service'

class ListPssPTIST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssPTIST3s: []
        }
        this.addPssPTIST3 = this.addPssPTIST3.bind(this);
        this.editPssPTIST3 = this.editPssPTIST3.bind(this);
        this.deletePssPTIST3 = this.deletePssPTIST3.bind(this);
    }

    deletePssPTIST3(id){
        PssPTIST3Service.deletePssPTIST3(id).then( res => {
            this.setState({pssPTIST3s: this.state.pssPTIST3s.filter(pssPTIST3 => pssPTIST3.pssPTIST3Id !== id)});
        });
    }
    viewPssPTIST3(id){
        this.props.history.push(`/view-pssPTIST3/${id}`);
    }
    editPssPTIST3(id){
        this.props.history.push(`/add-pssPTIST3/${id}`);
    }

    componentDidMount(){
        PssPTIST3Service.getPssPTIST3s().then((res) => {
            this.setState({ pssPTIST3s: res.data});
        });
    }

    addPssPTIST3(){
        this.props.history.push('/add-pssPTIST3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssPTIST3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssPTIST3}> Add PssPTIST3</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A0 </th>
                                    <th> A1 </th>
                                    <th> A2 </th>
                                    <th> A3 </th>
                                    <th> A4 </th>
                                    <th> A5 </th>
                                    <th> Al </th>
                                    <th> Athres </th>
                                    <th> B0 </th>
                                    <th> B1 </th>
                                    <th> B2 </th>
                                    <th> B3 </th>
                                    <th> B4 </th>
                                    <th> B5 </th>
                                    <th> Dl </th>
                                    <th> Dtc </th>
                                    <th> Dtf </th>
                                    <th> Dtp </th>
                                    <th> Isw </th>
                                    <th> K </th>
                                    <th> Lthres </th>
                                    <th> M </th>
                                    <th> Nav </th>
                                    <th> Ncl </th>
                                    <th> Ncr </th>
                                    <th> Pmin </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> Tf </th>
                                    <th> Tp </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssPTIST3s.map(
                                        pssPTIST3 => 
                                        <tr key = {pssPTIST3.pssPTIST3Id}>
                                             <td> { pssPTIST3.a0 } </td>
                                             <td> { pssPTIST3.a1 } </td>
                                             <td> { pssPTIST3.a2 } </td>
                                             <td> { pssPTIST3.a3 } </td>
                                             <td> { pssPTIST3.a4 } </td>
                                             <td> { pssPTIST3.a5 } </td>
                                             <td> { pssPTIST3.al } </td>
                                             <td> { pssPTIST3.athres } </td>
                                             <td> { pssPTIST3.b0 } </td>
                                             <td> { pssPTIST3.b1 } </td>
                                             <td> { pssPTIST3.b2 } </td>
                                             <td> { pssPTIST3.b3 } </td>
                                             <td> { pssPTIST3.b4 } </td>
                                             <td> { pssPTIST3.b5 } </td>
                                             <td> { pssPTIST3.dl } </td>
                                             <td> { pssPTIST3.dtc } </td>
                                             <td> { pssPTIST3.dtf } </td>
                                             <td> { pssPTIST3.dtp } </td>
                                             <td> { pssPTIST3.isw } </td>
                                             <td> { pssPTIST3.k } </td>
                                             <td> { pssPTIST3.lthres } </td>
                                             <td> { pssPTIST3.m } </td>
                                             <td> { pssPTIST3.nav } </td>
                                             <td> { pssPTIST3.ncl } </td>
                                             <td> { pssPTIST3.ncr } </td>
                                             <td> { pssPTIST3.pmin } </td>
                                             <td> { pssPTIST3.t1 } </td>
                                             <td> { pssPTIST3.t2 } </td>
                                             <td> { pssPTIST3.t3 } </td>
                                             <td> { pssPTIST3.t4 } </td>
                                             <td> { pssPTIST3.t5 } </td>
                                             <td> { pssPTIST3.t6 } </td>
                                             <td> { pssPTIST3.tf } </td>
                                             <td> { pssPTIST3.tp } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssPTIST3(pssPTIST3.pssPTIST3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssPTIST3(pssPTIST3.pssPTIST3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssPTIST3(pssPTIST3.pssPTIST3Id)} className="btn btn-info btn-sm">View </button>
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

export default ListPssPTIST3Component
