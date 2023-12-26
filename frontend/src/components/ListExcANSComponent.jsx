import React, { Component } from 'react'
import ExcANSService from '../services/ExcANSService'

class ListExcANSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excANSs: []
        }
        this.addExcANS = this.addExcANS.bind(this);
        this.editExcANS = this.editExcANS.bind(this);
        this.deleteExcANS = this.deleteExcANS.bind(this);
    }

    deleteExcANS(id){
        ExcANSService.deleteExcANS(id).then( res => {
            this.setState({excANSs: this.state.excANSs.filter(excANS => excANS.excANSId !== id)});
        });
    }
    viewExcANS(id){
        this.props.history.push(`/view-excANS/${id}`);
    }
    editExcANS(id){
        this.props.history.push(`/add-excANS/${id}`);
    }

    componentDidMount(){
        ExcANSService.getExcANSs().then((res) => {
            this.setState({ excANSs: res.data});
        });
    }

    addExcANS(){
        this.props.history.push('/add-excANS/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcANS List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcANS}> Add ExcANS</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Blint </th>
                                    <th> Ifmn </th>
                                    <th> Ifmx </th>
                                    <th> K2 </th>
                                    <th> K3 </th>
                                    <th> Kce </th>
                                    <th> Krvecc </th>
                                    <th> Kvfif </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> Tb </th>
                                    <th> Vrmn </th>
                                    <th> Vrmx </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excANSs.map(
                                        excANS => 
                                        <tr key = {excANS.excANSId}>
                                             <td> { excANS.blint } </td>
                                             <td> { excANS.ifmn } </td>
                                             <td> { excANS.ifmx } </td>
                                             <td> { excANS.k2 } </td>
                                             <td> { excANS.k3 } </td>
                                             <td> { excANS.kce } </td>
                                             <td> { excANS.krvecc } </td>
                                             <td> { excANS.kvfif } </td>
                                             <td> { excANS.t1 } </td>
                                             <td> { excANS.t2 } </td>
                                             <td> { excANS.t3 } </td>
                                             <td> { excANS.tb } </td>
                                             <td> { excANS.vrmn } </td>
                                             <td> { excANS.vrmx } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcANS(excANS.excANSId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcANS(excANS.excANSId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcANS(excANS.excANSId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcANSComponent
