import React, { Component } from 'react'
import PFVArControllerType2UserDefinedService from '../services/PFVArControllerType2UserDefinedService'

class ListPFVArControllerType2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pFVArControllerType2UserDefineds: []
        }
        this.addPFVArControllerType2UserDefined = this.addPFVArControllerType2UserDefined.bind(this);
        this.editPFVArControllerType2UserDefined = this.editPFVArControllerType2UserDefined.bind(this);
        this.deletePFVArControllerType2UserDefined = this.deletePFVArControllerType2UserDefined.bind(this);
    }

    deletePFVArControllerType2UserDefined(id){
        PFVArControllerType2UserDefinedService.deletePFVArControllerType2UserDefined(id).then( res => {
            this.setState({pFVArControllerType2UserDefineds: this.state.pFVArControllerType2UserDefineds.filter(pFVArControllerType2UserDefined => pFVArControllerType2UserDefined.pFVArControllerType2UserDefinedId !== id)});
        });
    }
    viewPFVArControllerType2UserDefined(id){
        this.props.history.push(`/view-pFVArControllerType2UserDefined/${id}`);
    }
    editPFVArControllerType2UserDefined(id){
        this.props.history.push(`/add-pFVArControllerType2UserDefined/${id}`);
    }

    componentDidMount(){
        PFVArControllerType2UserDefinedService.getPFVArControllerType2UserDefineds().then((res) => {
            this.setState({ pFVArControllerType2UserDefineds: res.data});
        });
    }

    addPFVArControllerType2UserDefined(){
        this.props.history.push('/add-pFVArControllerType2UserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PFVArControllerType2UserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPFVArControllerType2UserDefined}> Add PFVArControllerType2UserDefined</button>
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
                                    this.state.pFVArControllerType2UserDefineds.map(
                                        pFVArControllerType2UserDefined => 
                                        <tr key = {pFVArControllerType2UserDefined.pFVArControllerType2UserDefinedId}>
                                             <td> { pFVArControllerType2UserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editPFVArControllerType2UserDefined(pFVArControllerType2UserDefined.pFVArControllerType2UserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePFVArControllerType2UserDefined(pFVArControllerType2UserDefined.pFVArControllerType2UserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPFVArControllerType2UserDefined(pFVArControllerType2UserDefined.pFVArControllerType2UserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListPFVArControllerType2UserDefinedComponent
