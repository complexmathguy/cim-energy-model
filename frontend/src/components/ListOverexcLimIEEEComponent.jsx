import React, { Component } from 'react'
import OverexcLimIEEEService from '../services/OverexcLimIEEEService'

class ListOverexcLimIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                overexcLimIEEEs: []
        }
        this.addOverexcLimIEEE = this.addOverexcLimIEEE.bind(this);
        this.editOverexcLimIEEE = this.editOverexcLimIEEE.bind(this);
        this.deleteOverexcLimIEEE = this.deleteOverexcLimIEEE.bind(this);
    }

    deleteOverexcLimIEEE(id){
        OverexcLimIEEEService.deleteOverexcLimIEEE(id).then( res => {
            this.setState({overexcLimIEEEs: this.state.overexcLimIEEEs.filter(overexcLimIEEE => overexcLimIEEE.overexcLimIEEEId !== id)});
        });
    }
    viewOverexcLimIEEE(id){
        this.props.history.push(`/view-overexcLimIEEE/${id}`);
    }
    editOverexcLimIEEE(id){
        this.props.history.push(`/add-overexcLimIEEE/${id}`);
    }

    componentDidMount(){
        OverexcLimIEEEService.getOverexcLimIEEEs().then((res) => {
            this.setState({ overexcLimIEEEs: res.data});
        });
    }

    addOverexcLimIEEE(){
        this.props.history.push('/add-overexcLimIEEE/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OverexcLimIEEE List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOverexcLimIEEE}> Add OverexcLimIEEE</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Hyst </th>
                                    <th> Ifdlim </th>
                                    <th> Ifdmax </th>
                                    <th> Itfpu </th>
                                    <th> Kcd </th>
                                    <th> Kramp </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.overexcLimIEEEs.map(
                                        overexcLimIEEE => 
                                        <tr key = {overexcLimIEEE.overexcLimIEEEId}>
                                             <td> { overexcLimIEEE.hyst } </td>
                                             <td> { overexcLimIEEE.ifdlim } </td>
                                             <td> { overexcLimIEEE.ifdmax } </td>
                                             <td> { overexcLimIEEE.itfpu } </td>
                                             <td> { overexcLimIEEE.kcd } </td>
                                             <td> { overexcLimIEEE.kramp } </td>
                                             <td>
                                                 <button onClick={ () => this.editOverexcLimIEEE(overexcLimIEEE.overexcLimIEEEId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOverexcLimIEEE(overexcLimIEEE.overexcLimIEEEId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOverexcLimIEEE(overexcLimIEEE.overexcLimIEEEId)} className="btn btn-info btn-sm">View </button>
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

export default ListOverexcLimIEEEComponent
