import React, { Component } from 'react'
import UnderexcLim2SimplifiedService from '../services/UnderexcLim2SimplifiedService'

class ListUnderexcLim2SimplifiedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcLim2Simplifieds: []
        }
        this.addUnderexcLim2Simplified = this.addUnderexcLim2Simplified.bind(this);
        this.editUnderexcLim2Simplified = this.editUnderexcLim2Simplified.bind(this);
        this.deleteUnderexcLim2Simplified = this.deleteUnderexcLim2Simplified.bind(this);
    }

    deleteUnderexcLim2Simplified(id){
        UnderexcLim2SimplifiedService.deleteUnderexcLim2Simplified(id).then( res => {
            this.setState({underexcLim2Simplifieds: this.state.underexcLim2Simplifieds.filter(underexcLim2Simplified => underexcLim2Simplified.underexcLim2SimplifiedId !== id)});
        });
    }
    viewUnderexcLim2Simplified(id){
        this.props.history.push(`/view-underexcLim2Simplified/${id}`);
    }
    editUnderexcLim2Simplified(id){
        this.props.history.push(`/add-underexcLim2Simplified/${id}`);
    }

    componentDidMount(){
        UnderexcLim2SimplifiedService.getUnderexcLim2Simplifieds().then((res) => {
            this.setState({ underexcLim2Simplifieds: res.data});
        });
    }

    addUnderexcLim2Simplified(){
        this.props.history.push('/add-underexcLim2Simplified/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcLim2Simplified List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcLim2Simplified}> Add UnderexcLim2Simplified</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Kui </th>
                                    <th> P0 </th>
                                    <th> P1 </th>
                                    <th> Q0 </th>
                                    <th> Q1 </th>
                                    <th> Vuimax </th>
                                    <th> Vuimin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.underexcLim2Simplifieds.map(
                                        underexcLim2Simplified => 
                                        <tr key = {underexcLim2Simplified.underexcLim2SimplifiedId}>
                                             <td> { underexcLim2Simplified.kui } </td>
                                             <td> { underexcLim2Simplified.p0 } </td>
                                             <td> { underexcLim2Simplified.p1 } </td>
                                             <td> { underexcLim2Simplified.q0 } </td>
                                             <td> { underexcLim2Simplified.q1 } </td>
                                             <td> { underexcLim2Simplified.vuimax } </td>
                                             <td> { underexcLim2Simplified.vuimin } </td>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcLim2Simplified(underexcLim2Simplified.underexcLim2SimplifiedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcLim2Simplified(underexcLim2Simplified.underexcLim2SimplifiedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcLim2Simplified(underexcLim2Simplified.underexcLim2SimplifiedId)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcLim2SimplifiedComponent
