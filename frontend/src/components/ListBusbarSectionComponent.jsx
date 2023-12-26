import React, { Component } from 'react'
import BusbarSectionService from '../services/BusbarSectionService'

class ListBusbarSectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                busbarSections: []
        }
        this.addBusbarSection = this.addBusbarSection.bind(this);
        this.editBusbarSection = this.editBusbarSection.bind(this);
        this.deleteBusbarSection = this.deleteBusbarSection.bind(this);
    }

    deleteBusbarSection(id){
        BusbarSectionService.deleteBusbarSection(id).then( res => {
            this.setState({busbarSections: this.state.busbarSections.filter(busbarSection => busbarSection.busbarSectionId !== id)});
        });
    }
    viewBusbarSection(id){
        this.props.history.push(`/view-busbarSection/${id}`);
    }
    editBusbarSection(id){
        this.props.history.push(`/add-busbarSection/${id}`);
    }

    componentDidMount(){
        BusbarSectionService.getBusbarSections().then((res) => {
            this.setState({ busbarSections: res.data});
        });
    }

    addBusbarSection(){
        this.props.history.push('/add-busbarSection/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">BusbarSection List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBusbarSection}> Add BusbarSection</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> IpMax </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.busbarSections.map(
                                        busbarSection => 
                                        <tr key = {busbarSection.busbarSectionId}>
                                             <td> { busbarSection.ipMax } </td>
                                             <td>
                                                 <button onClick={ () => this.editBusbarSection(busbarSection.busbarSectionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBusbarSection(busbarSection.busbarSectionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBusbarSection(busbarSection.busbarSectionId)} className="btn btn-info btn-sm">View </button>
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

export default ListBusbarSectionComponent
