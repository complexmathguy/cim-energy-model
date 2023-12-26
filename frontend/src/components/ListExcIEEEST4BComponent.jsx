import React, { Component } from 'react'
import ExcIEEEST4BService from '../services/ExcIEEEST4BService'

class ListExcIEEEST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST4Bs: []
        }
        this.addExcIEEEST4B = this.addExcIEEEST4B.bind(this);
        this.editExcIEEEST4B = this.editExcIEEEST4B.bind(this);
        this.deleteExcIEEEST4B = this.deleteExcIEEEST4B.bind(this);
    }

    deleteExcIEEEST4B(id){
        ExcIEEEST4BService.deleteExcIEEEST4B(id).then( res => {
            this.setState({excIEEEST4Bs: this.state.excIEEEST4Bs.filter(excIEEEST4B => excIEEEST4B.excIEEEST4BId !== id)});
        });
    }
    viewExcIEEEST4B(id){
        this.props.history.push(`/view-excIEEEST4B/${id}`);
    }
    editExcIEEEST4B(id){
        this.props.history.push(`/add-excIEEEST4B/${id}`);
    }

    componentDidMount(){
        ExcIEEEST4BService.getExcIEEEST4Bs().then((res) => {
            this.setState({ excIEEEST4Bs: res.data});
        });
    }

    addExcIEEEST4B(){
        this.props.history.push('/add-excIEEEST4B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST4B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST4B}> Add ExcIEEEST4B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kc </th>
                                    <th> Kg </th>
                                    <th> Ki </th>
                                    <th> Kim </th>
                                    <th> Kir </th>
                                    <th> Kp </th>
                                    <th> Kpm </th>
                                    <th> Kpr </th>
                                    <th> Ta </th>
                                    <th> Thetap </th>
                                    <th> Vbmax </th>
                                    <th> Vmmax </th>
                                    <th> Vmmin </th>
                                    <th> Vrmax </th>
                                    <th> Vrmin </th>
                                    <th> Xl </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEST4Bs.map(
                                        excIEEEST4B => 
                                        <tr key = {excIEEEST4B.excIEEEST4BId}>
                                             <td> { excIEEEST4B.kc } </td>
                                             <td> { excIEEEST4B.kg } </td>
                                             <td> { excIEEEST4B.ki } </td>
                                             <td> { excIEEEST4B.kim } </td>
                                             <td> { excIEEEST4B.kir } </td>
                                             <td> { excIEEEST4B.kp } </td>
                                             <td> { excIEEEST4B.kpm } </td>
                                             <td> { excIEEEST4B.kpr } </td>
                                             <td> { excIEEEST4B.ta } </td>
                                             <td> { excIEEEST4B.thetap } </td>
                                             <td> { excIEEEST4B.vbmax } </td>
                                             <td> { excIEEEST4B.vmmax } </td>
                                             <td> { excIEEEST4B.vmmin } </td>
                                             <td> { excIEEEST4B.vrmax } </td>
                                             <td> { excIEEEST4B.vrmin } </td>
                                             <td> { excIEEEST4B.xl } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST4B(excIEEEST4B.excIEEEST4BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST4B(excIEEEST4B.excIEEEST4BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST4B(excIEEEST4B.excIEEEST4BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST4BComponent
