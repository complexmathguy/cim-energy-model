import React, { Component } from 'react'
import BusbarSectionService from '../services/BusbarSectionService';

class CreateBusbarSectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ipMax: ''
        }
        this.changeipMaxHandler = this.changeipMaxHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            BusbarSectionService.getBusbarSectionById(this.state.id).then( (res) =>{
                let busbarSection = res.data;
                this.setState({
                    ipMax: busbarSection.ipMax
                });
            });
        }        
    }
    saveOrUpdateBusbarSection = (e) => {
        e.preventDefault();
        let busbarSection = {
                busbarSectionId: this.state.id,
                ipMax: this.state.ipMax
            };
        console.log('busbarSection => ' + JSON.stringify(busbarSection));

        // step 5
        if(this.state.id === '_add'){
            busbarSection.busbarSectionId=''
            BusbarSectionService.createBusbarSection(busbarSection).then(res =>{
                this.props.history.push('/busbarSections');
            });
        }else{
            BusbarSectionService.updateBusbarSection(busbarSection).then( res => {
                this.props.history.push('/busbarSections');
            });
        }
    }
    
    changeipMaxHandler= (event) => {
        this.setState({ipMax: event.target.value});
    }

    cancel(){
        this.props.history.push('/busbarSections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add BusbarSection</h3>
        }else{
            return <h3 className="text-center">Update BusbarSection</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ipMax: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateBusbarSection}>Save</button>
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

export default CreateBusbarSectionComponent
