import React, { Component } from 'react'
import SvTapStepService from '../services/SvTapStepService'

class ListSvTapStepComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                svTapSteps: []
        }
        this.addSvTapStep = this.addSvTapStep.bind(this);
        this.editSvTapStep = this.editSvTapStep.bind(this);
        this.deleteSvTapStep = this.deleteSvTapStep.bind(this);
    }

    deleteSvTapStep(id){
        SvTapStepService.deleteSvTapStep(id).then( res => {
            this.setState({svTapSteps: this.state.svTapSteps.filter(svTapStep => svTapStep.svTapStepId !== id)});
        });
    }
    viewSvTapStep(id){
        this.props.history.push(`/view-svTapStep/${id}`);
    }
    editSvTapStep(id){
        this.props.history.push(`/add-svTapStep/${id}`);
    }

    componentDidMount(){
        SvTapStepService.getSvTapSteps().then((res) => {
            this.setState({ svTapSteps: res.data});
        });
    }

    addSvTapStep(){
        this.props.history.push('/add-svTapStep/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SvTapStep List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSvTapStep}> Add SvTapStep</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Position </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.svTapSteps.map(
                                        svTapStep => 
                                        <tr key = {svTapStep.svTapStepId}>
                                             <td> { svTapStep.position } </td>
                                             <td>
                                                 <button onClick={ () => this.editSvTapStep(svTapStep.svTapStepId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSvTapStep(svTapStep.svTapStepId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSvTapStep(svTapStep.svTapStepId)} className="btn btn-info btn-sm">View </button>
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

export default ListSvTapStepComponent
