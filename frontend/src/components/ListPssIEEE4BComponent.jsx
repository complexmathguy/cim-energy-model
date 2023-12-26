import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService'

class ListPssIEEE4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssIEEE4Bs: []
        }
        this.addPssIEEE4B = this.addPssIEEE4B.bind(this);
        this.editPssIEEE4B = this.editPssIEEE4B.bind(this);
        this.deletePssIEEE4B = this.deletePssIEEE4B.bind(this);
    }

    deletePssIEEE4B(id){
        PssIEEE4BService.deletePssIEEE4B(id).then( res => {
            this.setState({pssIEEE4Bs: this.state.pssIEEE4Bs.filter(pssIEEE4B => pssIEEE4B.pssIEEE4BId !== id)});
        });
    }
    viewPssIEEE4B(id){
        this.props.history.push(`/view-pssIEEE4B/${id}`);
    }
    editPssIEEE4B(id){
        this.props.history.push(`/add-pssIEEE4B/${id}`);
    }

    componentDidMount(){
        PssIEEE4BService.getPssIEEE4Bs().then((res) => {
            this.setState({ pssIEEE4Bs: res.data});
        });
    }

    addPssIEEE4B(){
        this.props.history.push('/add-pssIEEE4B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssIEEE4B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssIEEE4B}> Add PssIEEE4B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Bwh1 </th>
                                    <th> Bwh2 </th>
                                    <th> Bwl1 </th>
                                    <th> Bwl2 </th>
                                    <th> Kh </th>
                                    <th> Kh1 </th>
                                    <th> Kh11 </th>
                                    <th> Kh17 </th>
                                    <th> Kh2 </th>
                                    <th> Ki </th>
                                    <th> Ki1 </th>
                                    <th> Ki11 </th>
                                    <th> Ki17 </th>
                                    <th> Ki2 </th>
                                    <th> Kl </th>
                                    <th> Kl1 </th>
                                    <th> Kl11 </th>
                                    <th> Kl17 </th>
                                    <th> Kl2 </th>
                                    <th> Omeganh1 </th>
                                    <th> Omeganh2 </th>
                                    <th> Omeganl1 </th>
                                    <th> Omeganl2 </th>
                                    <th> Th1 </th>
                                    <th> Th10 </th>
                                    <th> Th11 </th>
                                    <th> Th12 </th>
                                    <th> Th2 </th>
                                    <th> Th3 </th>
                                    <th> Th4 </th>
                                    <th> Th5 </th>
                                    <th> Th6 </th>
                                    <th> Th7 </th>
                                    <th> Th8 </th>
                                    <th> Th9 </th>
                                    <th> Ti1 </th>
                                    <th> Ti10 </th>
                                    <th> Ti11 </th>
                                    <th> Ti12 </th>
                                    <th> Ti2 </th>
                                    <th> Ti3 </th>
                                    <th> Ti4 </th>
                                    <th> Ti5 </th>
                                    <th> Ti6 </th>
                                    <th> Ti7 </th>
                                    <th> Ti8 </th>
                                    <th> Ti9 </th>
                                    <th> Tl1 </th>
                                    <th> Tl10 </th>
                                    <th> Tl11 </th>
                                    <th> Tl12 </th>
                                    <th> Tl2 </th>
                                    <th> Tl3 </th>
                                    <th> Tl4 </th>
                                    <th> Tl5 </th>
                                    <th> Tl6 </th>
                                    <th> Tl7 </th>
                                    <th> Tl8 </th>
                                    <th> Tl9 </th>
                                    <th> Vhmax </th>
                                    <th> Vhmin </th>
                                    <th> Vimax </th>
                                    <th> Vimin </th>
                                    <th> Vlmax </th>
                                    <th> Vlmin </th>
                                    <th> Vstmax </th>
                                    <th> Vstmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssIEEE4Bs.map(
                                        pssIEEE4B => 
                                        <tr key = {pssIEEE4B.pssIEEE4BId}>
                                             <td> { pssIEEE4B.bwh1 } </td>
                                             <td> { pssIEEE4B.bwh2 } </td>
                                             <td> { pssIEEE4B.bwl1 } </td>
                                             <td> { pssIEEE4B.bwl2 } </td>
                                             <td> { pssIEEE4B.kh } </td>
                                             <td> { pssIEEE4B.kh1 } </td>
                                             <td> { pssIEEE4B.kh11 } </td>
                                             <td> { pssIEEE4B.kh17 } </td>
                                             <td> { pssIEEE4B.kh2 } </td>
                                             <td> { pssIEEE4B.ki } </td>
                                             <td> { pssIEEE4B.ki1 } </td>
                                             <td> { pssIEEE4B.ki11 } </td>
                                             <td> { pssIEEE4B.ki17 } </td>
                                             <td> { pssIEEE4B.ki2 } </td>
                                             <td> { pssIEEE4B.kl } </td>
                                             <td> { pssIEEE4B.kl1 } </td>
                                             <td> { pssIEEE4B.kl11 } </td>
                                             <td> { pssIEEE4B.kl17 } </td>
                                             <td> { pssIEEE4B.kl2 } </td>
                                             <td> { pssIEEE4B.omeganh1 } </td>
                                             <td> { pssIEEE4B.omeganh2 } </td>
                                             <td> { pssIEEE4B.omeganl1 } </td>
                                             <td> { pssIEEE4B.omeganl2 } </td>
                                             <td> { pssIEEE4B.th1 } </td>
                                             <td> { pssIEEE4B.th10 } </td>
                                             <td> { pssIEEE4B.th11 } </td>
                                             <td> { pssIEEE4B.th12 } </td>
                                             <td> { pssIEEE4B.th2 } </td>
                                             <td> { pssIEEE4B.th3 } </td>
                                             <td> { pssIEEE4B.th4 } </td>
                                             <td> { pssIEEE4B.th5 } </td>
                                             <td> { pssIEEE4B.th6 } </td>
                                             <td> { pssIEEE4B.th7 } </td>
                                             <td> { pssIEEE4B.th8 } </td>
                                             <td> { pssIEEE4B.th9 } </td>
                                             <td> { pssIEEE4B.ti1 } </td>
                                             <td> { pssIEEE4B.ti10 } </td>
                                             <td> { pssIEEE4B.ti11 } </td>
                                             <td> { pssIEEE4B.ti12 } </td>
                                             <td> { pssIEEE4B.ti2 } </td>
                                             <td> { pssIEEE4B.ti3 } </td>
                                             <td> { pssIEEE4B.ti4 } </td>
                                             <td> { pssIEEE4B.ti5 } </td>
                                             <td> { pssIEEE4B.ti6 } </td>
                                             <td> { pssIEEE4B.ti7 } </td>
                                             <td> { pssIEEE4B.ti8 } </td>
                                             <td> { pssIEEE4B.ti9 } </td>
                                             <td> { pssIEEE4B.tl1 } </td>
                                             <td> { pssIEEE4B.tl10 } </td>
                                             <td> { pssIEEE4B.tl11 } </td>
                                             <td> { pssIEEE4B.tl12 } </td>
                                             <td> { pssIEEE4B.tl2 } </td>
                                             <td> { pssIEEE4B.tl3 } </td>
                                             <td> { pssIEEE4B.tl4 } </td>
                                             <td> { pssIEEE4B.tl5 } </td>
                                             <td> { pssIEEE4B.tl6 } </td>
                                             <td> { pssIEEE4B.tl7 } </td>
                                             <td> { pssIEEE4B.tl8 } </td>
                                             <td> { pssIEEE4B.tl9 } </td>
                                             <td> { pssIEEE4B.vhmax } </td>
                                             <td> { pssIEEE4B.vhmin } </td>
                                             <td> { pssIEEE4B.vimax } </td>
                                             <td> { pssIEEE4B.vimin } </td>
                                             <td> { pssIEEE4B.vlmax } </td>
                                             <td> { pssIEEE4B.vlmin } </td>
                                             <td> { pssIEEE4B.vstmax } </td>
                                             <td> { pssIEEE4B.vstmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssIEEE4B(pssIEEE4B.pssIEEE4BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssIEEE4B(pssIEEE4B.pssIEEE4BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssIEEE4B(pssIEEE4B.pssIEEE4BId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssIEEE4BComponent
