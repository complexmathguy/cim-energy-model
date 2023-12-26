import React, { Component } from 'react'
import PFVArControllerType1UserDefinedService from '../services/PFVArControllerType1UserDefinedService'

class ListPFVArControllerType1UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArControllerType1UserDefineds: []
        }
        this.addPFVArControllerType1UserDefined = this.addPFVArControllerType1UserDefined.bind(this);
        this.editPFVArControllerType1UserDefined = this.editPFVArControllerType1UserDefined.bind(this);
        this.deletePFVArControllerType1UserDefined = this.deletePFVArControllerType1UserDefined.bind(this);
    }

    deletePFVArControllerType1UserDefined(id){
        PFVArControllerType1UserDefinedService.deletePFVArControllerType1UserDefined(id).then( res => {
            this.setState({pFVArControllerType1UserDefineds: this.state.pFVArControllerType1UserDefineds.filter(pFVArControllerType1UserDefined => pFVArControllerType1UserDefined.pFVArControllerType1UserDefinedId !== id)});
        });
    }
    viewPFVArControllerType1UserDefined(id){
        this.props.history.push(`/view-pFVArControllerType1UserDefined/${id}`);
    }
    editPFVArControllerType1UserDefined(id){
        this.props.history.push(`/add-pFVArControllerType1UserDefined/${id}`);
    }

    componentDidMount(){
        PFVArControllerType1UserDefinedService.getPFVArControllerType1UserDefineds().then((res) => {
            this.setState({ pFVArControllerType1UserDefineds: res.data});
        });
    }

    addPFVArControllerType1UserDefined(){
        this.props.history.push('/add-pFVArControllerType1UserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArControllerType1UserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArControllerType1UserDefined}> Add PFVArControllerType1UserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pFVArControllerType1UserDefineds.map(
                                        pFVArControllerType1UserDefined => 
                                        <tr key = {pFVArControllerType1UserDefined.pFVArControllerType1UserDefinedId}>
                                             <td> { pFVArControllerType1UserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArControllerType1UserDefined(pFVArControllerType1UserDefined.pFVArControllerType1UserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArControllerType1UserDefined(pFVArControllerType1UserDefined.pFVArControllerType1UserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArControllerType1UserDefined(pFVArControllerType1UserDefined.pFVArControllerType1UserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArControllerType1UserDefinedComponent
