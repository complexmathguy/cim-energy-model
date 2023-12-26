import React, { Component } from 'react'
import Pss5Service from '../services/Pss5Service'

class ListPss5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss5s: []
        }
        this.addPss5 = this.addPss5.bind(this);
        this.editPss5 = this.editPss5.bind(this);
        this.deletePss5 = this.deletePss5.bind(this);
    }

    deletePss5(id){
        Pss5Service.deletePss5(id).then( res => {
            this.setState({pss5s: this.state.pss5s.filter(pss5 => pss5.pss5Id !== id)});
        });
    }
    viewPss5(id){
        this.props.history.push(`/view-pss5/${id}`);
    }
    editPss5(id){
        this.props.history.push(`/add-pss5/${id}`);
    }

    componentDidMount(){
        Pss5Service.getPss5s().then((res) => {
            this.setState({ pss5s: res.data});
        });
    }

    addPss5(){
        this.props.history.push('/add-pss5/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss5 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss5}> Add Pss5</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ctw2 </th>
                                    <th> Deadband </th>
                                    <th> Isfreq </th>
                                    <th> Kf </th>
                                    <th> Kpe </th>
                                    <th> Kpss </th>
                                    <th> Pmm </th>
                                    <th> Tl1 </th>
                                    <th> Tl2 </th>
                                    <th> Tl3 </th>
                                    <th> Tl4 </th>
                                    <th> Tpe </th>
                                    <th> Tw1 </th>
                                    <th> Tw2 </th>
                                    <th> Vadat </th>
                                    <th> Vsmn </th>
                                    <th> Vsmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pss5s.map(
                                        pss5 => 
                                        <tr key = {pss5.pss5Id}>
                                             <td> { pss5.ctw2 } </td>
                                             <td> { pss5.deadband } </td>
                                             <td> { pss5.isfreq } </td>
                                             <td> { pss5.kf } </td>
                                             <td> { pss5.kpe } </td>
                                             <td> { pss5.kpss } </td>
                                             <td> { pss5.pmm } </td>
                                             <td> { pss5.tl1 } </td>
                                             <td> { pss5.tl2 } </td>
                                             <td> { pss5.tl3 } </td>
                                             <td> { pss5.tl4 } </td>
                                             <td> { pss5.tpe } </td>
                                             <td> { pss5.tw1 } </td>
                                             <td> { pss5.tw2 } </td>
                                             <td> { pss5.vadat } </td>
                                             <td> { pss5.vsmn } </td>
                                             <td> { pss5.vsmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss5(pss5.pss5Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss5(pss5.pss5Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss5(pss5.pss5Id)} className="btn btn-info btn-sm">View </button>
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

export default ListPss5Component
