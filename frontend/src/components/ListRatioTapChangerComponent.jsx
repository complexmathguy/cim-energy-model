import React, { Component } from 'react'
import RatioTapChangerService from '../services/RatioTapChangerService'

class ListRatioTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                ratioTapChangers: []
        }
        this.addRatioTapChanger = this.addRatioTapChanger.bind(this);
        this.editRatioTapChanger = this.editRatioTapChanger.bind(this);
        this.deleteRatioTapChanger = this.deleteRatioTapChanger.bind(this);
    }

    deleteRatioTapChanger(id){
        RatioTapChangerService.deleteRatioTapChanger(id).then( res => {
            this.setState({ratioTapChangers: this.state.ratioTapChangers.filter(ratioTapChanger => ratioTapChanger.ratioTapChangerId !== id)});
        });
    }
    viewRatioTapChanger(id){
        this.props.history.push(`/view-ratioTapChanger/${id}`);
    }
    editRatioTapChanger(id){
        this.props.history.push(`/add-ratioTapChanger/${id}`);
    }

    componentDidMount(){
        RatioTapChangerService.getRatioTapChangers().then((res) => {
            this.setState({ ratioTapChangers: res.data});
        });
    }

    addRatioTapChanger(){
        this.props.history.push('/add-ratioTapChanger/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RatioTapChanger List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRatioTapChanger}> Add RatioTapChanger</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> StepVoltageIncrement </th>
                                    <th> TculControlMode </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.ratioTapChangers.map(
                                        ratioTapChanger => 
                                        <tr key = {ratioTapChanger.ratioTapChangerId}>
                                             <td> { ratioTapChanger.stepVoltageIncrement } </td>
                                             <td> { ratioTapChanger.tculControlMode } </td>
                                             <td>
                                                 <button onClick={ () => this.editRatioTapChanger(ratioTapChanger.ratioTapChangerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRatioTapChanger(ratioTapChanger.ratioTapChangerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRatioTapChanger(ratioTapChanger.ratioTapChangerId)} className="btn btn-info btn-sm">View </button>
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

export default ListRatioTapChangerComponent
