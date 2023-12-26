import React, { Component } from 'react'
import BusbarSectionService from '../services/BusbarSectionService';

class UpdateBusbarSectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ipMax: ''
        }
        this.updateBusbarSection = this.updateBusbarSection.bind(this);

        this.changeipMaxHandler = this.changeipMaxHandler.bind(this);
    }

    componentDidMount(){
        BusbarSectionService.getBusbarSectionById(this.state.id).then( (res) =>{
            let busbarSection = res.data;
            this.setState({
                ipMax: busbarSection.ipMax
            });
        });
    }

    updateBusbarSection = (e) => {
        e.preventDefault();
        let busbarSection = {
            busbarSectionId: this.state.id,
            ipMax: this.state.ipMax
        };
        console.log('busbarSection => ' + JSON.stringify(busbarSection));
        console.log('id => ' + JSON.stringify(this.state.id));
        BusbarSectionService.updateBusbarSection(busbarSection).then( res => {
            this.props.history.push('/busbarSections');
        });
    }

    changeipMaxHandler= (event) => {
        this.setState({ipMax: event.target.value});
    }

    cancel(){
        this.props.history.push('/busbarSections');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BusbarSection</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ipMax: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBusbarSection}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateBusbarSectionComponent
