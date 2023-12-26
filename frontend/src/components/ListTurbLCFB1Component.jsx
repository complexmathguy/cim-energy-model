import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service'

class ListTurbLCFB1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                turbLCFB1s: []
        }
        this.addTurbLCFB1 = this.addTurbLCFB1.bind(this);
        this.editTurbLCFB1 = this.editTurbLCFB1.bind(this);
        this.deleteTurbLCFB1 = this.deleteTurbLCFB1.bind(this);
    }

    deleteTurbLCFB1(id){
        TurbLCFB1Service.deleteTurbLCFB1(id).then( res => {
            this.setState({turbLCFB1s: this.state.turbLCFB1s.filter(turbLCFB1 => turbLCFB1.turbLCFB1Id !== id)});
        });
    }
    viewTurbLCFB1(id){
        this.props.history.push(`/view-turbLCFB1/${id}`);
    }
    editTurbLCFB1(id){
        this.props.history.push(`/add-turbLCFB1/${id}`);
    }

    componentDidMount(){
        TurbLCFB1Service.getTurbLCFB1s().then((res) => {
            this.setState({ turbLCFB1s: res.data});
        });
    }

    addTurbLCFB1(){
        this.props.history.push('/add-turbLCFB1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TurbLCFB1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTurbLCFB1}> Add TurbLCFB1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Db </th>
                                    <th> Emax </th>
                                    <th> Fb </th>
                                    <th> Fbf </th>
                                    <th> Irmax </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Mwbase </th>
                                    <th> Pbf </th>
                                    <th> Pmwset </th>
                                    <th> SpeedReferenceGovernor </th>
                                    <th> Tpelec </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.turbLCFB1s.map(
                                        turbLCFB1 => 
                                        <tr key = {turbLCFB1.turbLCFB1Id}>
                                             <td> { turbLCFB1.db } </td>
                                             <td> { turbLCFB1.emax } </td>
                                             <td> { turbLCFB1.fb } </td>
                                             <td> { turbLCFB1.fbf } </td>
                                             <td> { turbLCFB1.irmax } </td>
                                             <td> { turbLCFB1.ki } </td>
                                             <td> { turbLCFB1.kp } </td>
                                             <td> { turbLCFB1.mwbase } </td>
                                             <td> { turbLCFB1.pbf } </td>
                                             <td> { turbLCFB1.pmwset } </td>
                                             <td> { turbLCFB1.speedReferenceGovernor } </td>
                                             <td> { turbLCFB1.tpelec } </td>
                                             <td>
                                                 <button onClick={ () => this.editTurbLCFB1(turbLCFB1.turbLCFB1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTurbLCFB1(turbLCFB1.turbLCFB1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTurbLCFB1(turbLCFB1.turbLCFB1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListTurbLCFB1Component
