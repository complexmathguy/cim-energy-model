import React, { Component } from 'react'
import OverexcLim2Service from '../services/OverexcLim2Service'

class ListOverexcLim2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                overexcLim2s: []
        }
        this.addOverexcLim2 = this.addOverexcLim2.bind(this);
        this.editOverexcLim2 = this.editOverexcLim2.bind(this);
        this.deleteOverexcLim2 = this.deleteOverexcLim2.bind(this);
    }

    deleteOverexcLim2(id){
        OverexcLim2Service.deleteOverexcLim2(id).then( res => {
            this.setState({overexcLim2s: this.state.overexcLim2s.filter(overexcLim2 => overexcLim2.overexcLim2Id !== id)});
        });
    }
    viewOverexcLim2(id){
        this.props.history.push(`/view-overexcLim2/${id}`);
    }
    editOverexcLim2(id){
        this.props.history.push(`/add-overexcLim2/${id}`);
    }

    componentDidMount(){
        OverexcLim2Service.getOverexcLim2s().then((res) => {
            this.setState({ overexcLim2s: res.data});
        });
    }

    addOverexcLim2(){
        this.props.history.push('/add-overexcLim2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OverexcLim2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOverexcLim2}> Add OverexcLim2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ifdlim </th>
                                    <th> Koi </th>
                                    <th> Voimax </th>
                                    <th> Voimin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.overexcLim2s.map(
                                        overexcLim2 => 
                                        <tr key = {overexcLim2.overexcLim2Id}>
                                             <td> { overexcLim2.ifdlim } </td>
                                             <td> { overexcLim2.koi } </td>
                                             <td> { overexcLim2.voimax } </td>
                                             <td> { overexcLim2.voimin } </td>
                                             <td>
                                                 <button onClick={ () => this.editOverexcLim2(overexcLim2.overexcLim2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOverexcLim2(overexcLim2.overexcLim2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOverexcLim2(overexcLim2.overexcLim2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListOverexcLim2Component
