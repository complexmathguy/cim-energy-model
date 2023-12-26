import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService'

class ListExcIEEEST5BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST5Bs: []
        }
        this.addExcIEEEST5B = this.addExcIEEEST5B.bind(this);
        this.editExcIEEEST5B = this.editExcIEEEST5B.bind(this);
        this.deleteExcIEEEST5B = this.deleteExcIEEEST5B.bind(this);
    }

    deleteExcIEEEST5B(id){
        ExcIEEEST5BService.deleteExcIEEEST5B(id).then( res => {
            this.setState({excIEEEST5Bs: this.state.excIEEEST5Bs.filter(excIEEEST5B => excIEEEST5B.excIEEEST5BId !== id)});
        });
    }
    viewExcIEEEST5B(id){
        this.props.history.push(`/view-excIEEEST5B/${id}`);
    }
    editExcIEEEST5B(id){
        this.props.history.push(`/add-excIEEEST5B/${id}`);
    }

    componentDidMount(){
        ExcIEEEST5BService.getExcIEEEST5Bs().then((res) => {
            this.setState({ excIEEEST5Bs: res.data});
        });
    }

    addExcIEEEST5B(){
        this.props.history.push('/add-excIEEEST5B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST5B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST5B}> Add ExcIEEEST5B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kc </th>
                                    <th> Kr </th>
                                    <th> T1 </th>
                                    <th> Tb1 </th>
                                    <th> Tb2 </th>
                                    <th> Tc1 </th>
                                    <th> Tc2 </th>
                                    <th> Tob1 </th>
                                    <th> Tob2 </th>
                                    <th> Toc1 </th>
                                    <th> Toc2 </th>
                                    <th> Tub1 </th>
                                    <th> Tub2 </th>
                                    <th> Tuc1 </th>
                                    <th> Tuc2 </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEST5Bs.map(
                                        excIEEEST5B => 
                                        <tr key = {excIEEEST5B.excIEEEST5BId}>
                                             <td> { excIEEEST5B.kc } </td>
                                             <td> { excIEEEST5B.kr } </td>
                                             <td> { excIEEEST5B.t1 } </td>
                                             <td> { excIEEEST5B.tb1 } </td>
                                             <td> { excIEEEST5B.tb2 } </td>
                                             <td> { excIEEEST5B.tc1 } </td>
                                             <td> { excIEEEST5B.tc2 } </td>
                                             <td> { excIEEEST5B.tob1 } </td>
                                             <td> { excIEEEST5B.tob2 } </td>
                                             <td> { excIEEEST5B.toc1 } </td>
                                             <td> { excIEEEST5B.toc2 } </td>
                                             <td> { excIEEEST5B.tub1 } </td>
                                             <td> { excIEEEST5B.tub2 } </td>
                                             <td> { excIEEEST5B.tuc1 } </td>
                                             <td> { excIEEEST5B.tuc2 } </td>
                                             <td> { excIEEEST5B.vrmax } </td>
                                             <td> { excIEEEST5B.vrmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST5B(excIEEEST5B.excIEEEST5BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST5B(excIEEEST5B.excIEEEST5BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST5B(excIEEEST5B.excIEEEST5BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST5BComponent
