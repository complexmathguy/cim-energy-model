import React, { Component } from 'react'
import RegulatingCondEqService from '../services/RegulatingCondEqService'

class ListRegulatingCondEqComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                regulatingCondEqs: []
        }
        this.addRegulatingCondEq = this.addRegulatingCondEq.bind(this);
        this.editRegulatingCondEq = this.editRegulatingCondEq.bind(this);
        this.deleteRegulatingCondEq = this.deleteRegulatingCondEq.bind(this);
    }

    deleteRegulatingCondEq(id){
        RegulatingCondEqService.deleteRegulatingCondEq(id).then( res => {
            this.setState({regulatingCondEqs: this.state.regulatingCondEqs.filter(regulatingCondEq => regulatingCondEq.regulatingCondEqId !== id)});
        });
    }
    viewRegulatingCondEq(id){
        this.props.history.push(`/view-regulatingCondEq/${id}`);
    }
    editRegulatingCondEq(id){
        this.props.history.push(`/add-regulatingCondEq/${id}`);
    }

    componentDidMount(){
        RegulatingCondEqService.getRegulatingCondEqs().then((res) => {
            this.setState({ regulatingCondEqs: res.data});
        });
    }

    addRegulatingCondEq(){
        this.props.history.push('/add-regulatingCondEq/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RegulatingCondEq List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRegulatingCondEq}> Add RegulatingCondEq</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.regulatingCondEqs.map(
                                        regulatingCondEq => 
                                        <tr key = {regulatingCondEq.regulatingCondEqId}>
                                             <td>
                                                 <button onClick={ () => this.editRegulatingCondEq(regulatingCondEq.regulatingCondEqId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRegulatingCondEq(regulatingCondEq.regulatingCondEqId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRegulatingCondEq(regulatingCondEq.regulatingCondEqId)} className="btn btn-info btn-sm">View </button>
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

export default ListRegulatingCondEqComponent
